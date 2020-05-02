package com.future.media

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.ResultReceiver
import android.support.v4.media.session.PlaybackStateCompat
import com.google.android.exoplayer2.ControlDispatcher
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector
import com.google.android.exoplayer2.source.ConcatenatingMediaSource
import com.google.android.exoplayer2.upstream.DataSource

class MediaPlaybackPreparer(context: Context,
                            private val simpleExoPlayer: SimpleExoPlayer,
                            private val dataSourceFactory: DataSource.Factory
) : MediaSessionConnector.PlaybackPreparer {

    private val mediaModelHelper = MediaModelHelper(context)

    private val commandList = ArrayList<String>().also {
        it.add(MediaCommand.NOTIFICATION_STATUS_SHOW)
        it.add(MediaCommand.NOTIFICATION_STATUS_HIDE)
    }
    var mediaNotificationListener: MediaNotificationListener? = null

    override fun onPrepareFromSearch(query: String, playWhenReady: Boolean, extras: Bundle) {
        // do nothing
    }

    override fun onCommand(player: Player, controlDispatcher: ControlDispatcher, command: String,
                           extras: Bundle, cb: ResultReceiver): Boolean {
        when (command) {
            MediaCommand.NOTIFICATION_STATUS_SHOW -> {
                mediaNotificationListener?.showMediaNotification()
            }
            MediaCommand.NOTIFICATION_STATUS_HIDE -> {
                mediaNotificationListener?.hideMediaNotification()
            }
            else -> {
                // do nothing
            }
        }
        return true
    }

    override fun getSupportedPrepareActions(): Long =
            PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID or
                    PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID or
                    PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH or
                    PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH

    override fun onPrepareFromMediaId(mediaId: String, playWhenReady: Boolean, extras: Bundle) {
        preparePLayMedia(mediaId)
    }

    override fun onPrepareFromUri(uri: Uri, playWhenReady: Boolean, extras: Bundle) {
        // do nothing
    }

    override fun onPrepare(playWhenReady: Boolean) {
        // do nothing
    }

    fun getCommands(): Array<String> {
        return commandList.toTypedArray()
    }

    private fun preparePLayMedia(mediaId: String) {
        val mediaDataSource = MediaDataSource.get()
        val playMediaModel = mediaDataSource.getMediaModel(mediaId)
        if (playMediaModel != null) {
            val audioList = mediaDataSource.getMediaList()
            val initialWindowIndex = audioList.indexOf(playMediaModel)

            mediaModelHelper.getConcatenatingMediaSource(audioList,
                    dataSourceFactory, object : MediaSourceListener {
                override fun onMediaSourceSuccess(mediaSource: ConcatenatingMediaSource) {
                    simpleExoPlayer.prepare(mediaSource)
                    simpleExoPlayer.seekTo(initialWindowIndex, 0)
                }
            })
        }
    }

    fun isShowNotification(): Boolean = MediaCommand.get().isNotificationStatusShow()

    fun clear() {
        mediaModelHelper.clear()
    }
}