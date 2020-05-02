package com.future.media

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import android.support.v4.media.MediaDescriptionCompat
import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.MediaControllerCompat
import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat
import android.support.v4.media.session.PlaybackStateCompat.*
import android.widget.RemoteViews
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.media.session.MediaButtonReceiver


class NotificationBuilder(private val context: Context) {

    companion object {

        const val NOTIFICATION_SKIP_TO_PREVIOUS = "notification_skip_to_previous"
        const val NOTIFICATION_PLAY = "notification_play"
        const val NOTIFICATION_PAUSE = "notification_pause"
        const val NOTIFICATION_SKIP_TO_NEXT = "notification_skip_to_next"
        const val NOTIFICATION_CHANNEL = "notification_channel"
        const val NOTIFICATION_CHANNEL_DESCRIPTION = "notification_channel_description"

        const val NOW_PLAYING_CHANNEL: String = "com.future.media.NOW_PLAYING"
        const val NOW_PLAYING_NOTIFICATION: Int = 1126
    }

    private val platformNotificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    private val skipToPreviousAction = NotificationCompat.Action(
            R.drawable.exo_controls_previous,
            NOTIFICATION_SKIP_TO_PREVIOUS,
            MediaButtonReceiver.buildMediaButtonPendingIntent(context, ACTION_SKIP_TO_PREVIOUS))
    private val playAction = NotificationCompat.Action(
            R.drawable.exo_controls_play,
            NOTIFICATION_PLAY,
            MediaButtonReceiver.buildMediaButtonPendingIntent(context, ACTION_PLAY))
    private val pauseAction = NotificationCompat.Action(
            R.drawable.exo_controls_pause,
            NOTIFICATION_PAUSE,
            MediaButtonReceiver.buildMediaButtonPendingIntent(context, ACTION_PAUSE))
    private val skipToNextAction = NotificationCompat.Action(
            R.drawable.exo_controls_next,
            NOTIFICATION_SKIP_TO_NEXT,
            MediaButtonReceiver.buildMediaButtonPendingIntent(context, ACTION_SKIP_TO_NEXT))
    private val stopPendingIntent =
            MediaButtonReceiver.buildMediaButtonPendingIntent(context, ACTION_STOP)

    fun buildNotification(sessionToken: MediaSessionCompat.Token): Notification {
        if (shouldCreateNowPlayingChannel()) {
            createNowPlayingChannel()
        }
        val controller = MediaControllerCompat(context, sessionToken)
        val metadata = controller.metadata
        val description = metadata.description
        val playbackState = controller.playbackState

        val builder = NotificationCompat.Builder(context, NOW_PLAYING_CHANNEL)
        builder.setContentIntent(controller.sessionActivity)
                .setDeleteIntent(stopPendingIntent)
                .setContentTitle(description.title)
                .setContentText(description.subtitle)
                .setLargeIcon(description.iconBitmap)
                .setSmallIcon(R.drawable.media_small_notification)
                .setColor(ContextCompat.getColor(context, android.R.color.transparent))
                .setShowWhen(false)
                .setOngoing(true)
                .setOnlyAlertOnce(true)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            handleMediaStyle(builder, sessionToken, playbackState, metadata)
        } else {
            handleRemoteViews(builder, description.iconBitmap, description, playbackState, metadata)
        }
        if (playbackState.state == PlaybackStateCompat.STATE_PAUSED ||
                playbackState.state == PlaybackStateCompat.STATE_STOPPED) {
            builder.setOngoing(false)
        }
        return builder.build()
    }

    private fun handleMediaStyle(builder: NotificationCompat.Builder,
                                 sessionToken: MediaSessionCompat.Token,
                                 playbackState: PlaybackStateCompat,
                                 metadata: MediaMetadataCompat) {
        var actionsPosition = 0
        val actionList = ArrayList<Int>()
        if (!MediaModelHelper.isMediaPrevious(metadata)) {
            builder.addAction(skipToPreviousAction)
            actionList.add(actionsPosition)
            actionsPosition++
        }
        if (playbackState.isPlaying) {
            builder.addAction(pauseAction)
            actionList.add(actionsPosition)
            actionsPosition++
        } else if (playbackState.isPlayEnabled) {
            builder.addAction(playAction)
            actionList.add(actionsPosition)
            actionsPosition++
        }
        if (playbackState.isSkipToNextEnabled) {
            builder.addAction(skipToNextAction)
            actionList.add(actionsPosition)
        }
        val actionArr = actionList.toIntArray()
        val style =  androidx.media.app.NotificationCompat.MediaStyle()
        style.setMediaSession(sessionToken)
                .setShowActionsInCompactView(* actionArr)
                .setCancelButtonIntent(stopPendingIntent)
                .setShowCancelButton(true)
        builder.setStyle(style)
    }

    private fun handleRemoteViews(builder: NotificationCompat.Builder,
                                  iconBitmap: Bitmap?,
                                  mediaDescription: MediaDescriptionCompat,
                                  playbackState: PlaybackStateCompat,
                                  metadata: MediaMetadataCompat) {
        val mediaList = MediaDataSource.get().getMediaList()
        val currentMedia = mediaList.find {
            MediaModelHelper.getMediaId(metadata) == MediaModelHelper.getMediaId(it)
        }
        var currentIndex = 0
        if (currentMedia != null) {
            currentIndex = mediaList.indexOf(currentMedia)
        }
        val remoteViews = RemoteViews(context.packageName, R.layout.media_layout_notification)
        remoteViews.setTextViewText(R.id.notificationMediaTitleTv, mediaDescription.title)
        remoteViews.setImageViewBitmap(R.id.notificationMediaIconIv, iconBitmap)

        if (currentIndex > 0) {
            remoteViews.setOnClickPendingIntent(R.id.notificationMediaPreviousIv,
                    MediaButtonReceiver.buildMediaButtonPendingIntent(context, ACTION_SKIP_TO_PREVIOUS))
        }
        if (playbackState.isPlaying) {
            remoteViews.setImageViewResource(R.id.notificationMediaPlayIv,
                    R.drawable.ic_android_player_play)
            remoteViews.setOnClickPendingIntent(R.id.notificationMediaPlayIv,
                    MediaButtonReceiver.buildMediaButtonPendingIntent(context, ACTION_PAUSE))
        } else if (playbackState.isPlayEnabled) {
            remoteViews.setImageViewResource(R.id.notificationMediaPlayIv,
                    R.drawable.ic_android_player_suspended)
            remoteViews.setOnClickPendingIntent(R.id.notificationMediaPlayIv,
                    MediaButtonReceiver.buildMediaButtonPendingIntent(context, ACTION_PLAY))
        }
        if (currentIndex < mediaList.size - 1) {
            remoteViews.setOnClickPendingIntent(R.id.notificationMediaNextIv,
                    MediaButtonReceiver.buildMediaButtonPendingIntent(context, ACTION_SKIP_TO_NEXT))
        }
        remoteViews.setOnClickPendingIntent(R.id.notificationMediaCloseIv,
                MediaButtonReceiver.buildMediaButtonPendingIntent(context, ACTION_STOP))
        builder.setContent(remoteViews)
                .setCustomContentView(remoteViews)
    }

    private fun shouldCreateNowPlayingChannel() =
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && !nowPlayingChannelExists()

    @RequiresApi(Build.VERSION_CODES.O)
    private fun nowPlayingChannelExists() =
            platformNotificationManager.getNotificationChannel(NOW_PLAYING_CHANNEL) != null

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNowPlayingChannel() {
        val notificationChannel = NotificationChannel(NOW_PLAYING_CHANNEL,
                NOTIFICATION_CHANNEL,
                NotificationManager.IMPORTANCE_LOW)
                .apply {
                    description = NOTIFICATION_CHANNEL_DESCRIPTION
                }
        platformNotificationManager.createNotificationChannel(notificationChannel)
    }
}