package com.future.media

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.AudioManager
import android.os.Bundle
import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.MediaControllerCompat
import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.media.MediaBrowserServiceCompat
import androidx.media.session.MediaButtonReceiver
import com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.upstream.cache.CacheDataSourceFactory
import com.google.android.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor
import com.google.android.exoplayer2.upstream.cache.SimpleCache
import com.google.android.exoplayer2.util.Util
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.subjects.PublishSubject
import java.io.File
import java.util.concurrent.TimeUnit

class MediaService : MediaBrowserServiceCompat() {

    companion object {

        const val TAG = "MediaService"
        const val USER_AGENT = "media.user"
        const val BROWSE_ROOT = "/"
        const val CACHE_DIR_NAME = "media"
        const val CACHE_MEDIA_MAX_BYTES = 50 * 1024 * 1024L

        private const val SHOW_MEDIA_NOTIFICATION = "SHOW_MEDIA_NOTIFICATION"
        private const val NOTIFICATION_TIME_OUT = 250L

        private var SIMPLE_CACHE: SimpleCache? = null
    }

    private var mediaSession: MediaSessionCompat? = null
    private var mediaSessionConnector: MediaSessionConnector? = null
    private var mediaController: MediaControllerCompat? = null
    private var notificationManager: NotificationManagerCompat? = null
    private var notificationBuilder: NotificationBuilder? = null
    private var becomingNoisyReceiver: BecomingNoisyReceiver? = null
    private var mediaPlaybackPreparer: MediaPlaybackPreparer? = null

    private var isForegroundService = false
    private var currentMetadata: MediaMetadataCompat? = null

    private val mediaNotificationListener = object : MediaNotificationListener {

        override fun showMediaNotification() {
            this@MediaService.showMediaNotification()
        }

        override fun hideMediaNotification() {
            this@MediaService.hideMediaNotification()
        }
    }

    private val notificationSubject = PublishSubject.create<String>()

    override fun onLoadChildren(parentId: String, result: Result<MutableList<MediaBrowserCompat.MediaItem>>) {
        result.sendResult(ArrayList())
    }

    override fun onGetRoot(clientPackageName: String, clientUid: Int, rootHints: Bundle?): BrowserRoot? {
        return BrowserRoot(BROWSE_ROOT, null)
    }

    override fun onCreate() {
        super.onCreate()
        val sessionIntent = packageManager?.getLaunchIntentForPackage(packageName)
        val sessionActivityPendingIntent = PendingIntent.getActivity(this,
            0, sessionIntent, 0)
        val mediaSession = MediaSessionCompat(this, TAG)
        this.mediaSession = mediaSession
        mediaSession.setSessionActivity(sessionActivityPendingIntent)
        mediaSession.isActive = true

        sessionToken = mediaSession.sessionToken
        val mediaController = MediaControllerCompat(this, mediaSession)
        this.mediaController = mediaController
        mediaController.registerCallback(MediaControllerCallback())

        val notificationBuilder = NotificationBuilder(this)
        this.notificationBuilder = notificationBuilder
        val becomingNoisyReceiver = BecomingNoisyReceiver(this, mediaSession.sessionToken)
        this.becomingNoisyReceiver = becomingNoisyReceiver
        val mediaSessionConnector = MediaSessionConnector(mediaSession)
        this.mediaSessionConnector = mediaSessionConnector

        val mediaExoPlayerHelper = MediaExoPlayerHelper.get()
        mediaExoPlayerHelper.initSimpleExoPlayer(this)
        val exoPlayer = mediaExoPlayerHelper.getSimpleExoPlayer()
        if (exoPlayer != null) {
            val cacheDataSourceFactory = getCacheDataSourceFactory()
            val mediaPlaybackPreparer = MediaPlaybackPreparer(this, exoPlayer, cacheDataSourceFactory)
            this.mediaPlaybackPreparer = mediaPlaybackPreparer
            mediaPlaybackPreparer.mediaNotificationListener = mediaNotificationListener
            mediaSessionConnector.setPlayer(exoPlayer)
            mediaSessionConnector.setPlaybackPreparer(mediaPlaybackPreparer)
            mediaSessionConnector.setQueueNavigator(MediaQueueNavigator(mediaSession))
        }
        notificationSubject.debounce(NOTIFICATION_TIME_OUT, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<String>() {

                override fun onComplete() {
                    // do nothing
                }

                override fun onNext(stateJson: String) {
                    handleShowMediaNotification()
                }

                override fun onError(e: Throwable) {
                    // do nothing
                }
            })
    }

    private fun getCacheDataSourceFactory(): CacheDataSourceFactory {
        val defaultHttpDataSourceFactory = DefaultHttpDataSourceFactory(Util.getUserAgent(this, USER_AGENT),
            null, DefaultHttpDataSource.DEFAULT_CONNECT_TIMEOUT_MILLIS,
            DefaultHttpDataSource.DEFAULT_READ_TIMEOUT_MILLIS, true)
        val dataSourceFactory = DefaultDataSourceFactory(this, defaultHttpDataSourceFactory)
        if (SIMPLE_CACHE == null) {
            SIMPLE_CACHE = getSimpleCache()
        }
        return CacheDataSourceFactory(SIMPLE_CACHE, dataSourceFactory)
    }

    private fun getSimpleCache(): SimpleCache {
        val cacheFolder = File(cacheDir, CACHE_DIR_NAME)
        val leastRecentlyUsedCache = LeastRecentlyUsedCacheEvictor(CACHE_MEDIA_MAX_BYTES)
        return SimpleCache(cacheFolder, leastRecentlyUsedCache)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        MediaButtonReceiver.handleIntent(mediaSession, intent)
        mediaSession?.sessionToken?.let {
            val notification = notificationBuilder?.buildNotification(it)
            startForeground(NotificationBuilder.NOW_PLAYING_NOTIFICATION, notification)
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onTaskRemoved(rootIntent: Intent) {
        super.onTaskRemoved(rootIntent)
        MediaExoPlayerHelper.get().getSimpleExoPlayer()?.stop(true)
    }

    override fun onDestroy() {
        val mediaSession = mediaSession
        if (mediaSession != null) {
            mediaSession.isActive = false
            mediaSession.release()
        }
        mediaPlaybackPreparer?.clear()
        MediaExoPlayerHelper.get().releaseSimpleExoPlayer()
    }

    private fun removeNowPlayingNotification() {
        stopForeground(true)
    }

    private fun showMediaNotification() {
        val mediaPlaybackPreparer = mediaPlaybackPreparer
        if (mediaPlaybackPreparer != null && mediaPlaybackPreparer.isShowNotification()) {
            notificationSubject.onNext(SHOW_MEDIA_NOTIFICATION)
        }
    }

    private fun handleShowMediaNotification() {
        val playbackState = mediaController?.playbackState
        if (playbackState != null) {
            val mediaPlaybackPreparer = mediaPlaybackPreparer
            if (playbackState.isPrepared && mediaPlaybackPreparer != null &&
                mediaPlaybackPreparer.isShowNotification()) {
                val notificationBuilder = notificationBuilder
                val mediaSession = mediaSession
                val notificationManager = notificationManager
                if (notificationManager != null && notificationBuilder != null && mediaSession != null) {
                    val notification = notificationBuilder.buildNotification(mediaSession.sessionToken)
                    becomingNoisyReceiver?.register()
                    if (!isForegroundService) {
                        ContextCompat.startForegroundService(
                            applicationContext,
                            Intent(applicationContext, this@MediaService.javaClass)
                        )
                        startForeground(NotificationBuilder.NOW_PLAYING_NOTIFICATION, notification)
                        isForegroundService = true
                    }
                    notificationManager.notify(NotificationBuilder.NOW_PLAYING_NOTIFICATION, notification)
                }
            }
        }
    }

    private fun hideMediaNotification() {
        val playbackState = mediaController?.playbackState
        if (playbackState != null) {
            val updatedState = playbackState.state
            becomingNoisyReceiver?.unregister()
            if (isForegroundService) {
                removeNowPlayingNotification()
                isForegroundService = false
            }
            notificationManager?.cancel(NotificationBuilder.NOW_PLAYING_NOTIFICATION)
            if (updatedState == PlaybackStateCompat.STATE_NONE) {
                stopSelf()
            }
        }
    }

    private inner class MediaControllerCallback : MediaControllerCompat.Callback() {
        override fun onMetadataChanged(metadata: MediaMetadataCompat?) {
            metadata?.let {
                currentMetadata = metadata
                mediaController?.playbackState?.let { playbackState ->
                    updateNotification(playbackState)
                }
            }
        }

        override fun onPlaybackStateChanged(state: PlaybackStateCompat?) {
            if (state != null && currentMetadata != null) {
                updateNotification(state)
            }
        }

        private fun updateNotification(state: PlaybackStateCompat) {
            var notificationManager = notificationManager
            if (notificationManager == null) {
                notificationManager = NotificationManagerCompat.from(this@MediaService)
                this@MediaService.notificationManager = notificationManager
            }
            val updatedState = state.state
            val metadata = mediaController?.metadata
            when (updatedState) {
                PlaybackStateCompat.STATE_BUFFERING,
                PlaybackStateCompat.STATE_PLAYING -> {
                    showMediaNotification()
                }
                PlaybackStateCompat.STATE_STOPPED,
                PlaybackStateCompat.STATE_NONE -> {
                    hideMediaNotification()
                }
                else -> {
                    becomingNoisyReceiver?.unregister()
                    if (isForegroundService) {
                        stopForeground(false)
                        isForegroundService = false
                    }
                    val mediaPlaybackPreparer = mediaPlaybackPreparer
                    if (mediaPlaybackPreparer != null &&
                        mediaPlaybackPreparer.isShowNotification()) {
                        val notificationBuilder = notificationBuilder
                        val mediaSession = mediaSession
                        if (metadata != null && notificationBuilder != null && mediaSession != null) {
                            val notification = notificationBuilder.buildNotification(mediaSession.sessionToken)
                            notificationManager.notify(NotificationBuilder.NOW_PLAYING_NOTIFICATION,
                                notification)
                        }
                    }
                }
            }
        }
    }

    private class BecomingNoisyReceiver(private val context: Context,
                                        sessionToken: MediaSessionCompat.Token) : BroadcastReceiver() {

        private val noisyIntentFilter = IntentFilter(AudioManager.ACTION_AUDIO_BECOMING_NOISY)
        private val controller = MediaControllerCompat(context, sessionToken)
        private var registered = false

        fun register() {
            if (!registered) {
                context.registerReceiver(this, noisyIntentFilter)
                registered = true
            }
        }

        fun unregister() {
            if (registered) {
                context.unregisterReceiver(this)
                registered = false
            }
        }

        override fun onReceive(context: Context, intent: Intent) {
            if (intent.action == AudioManager.ACTION_AUDIO_BECOMING_NOISY) {
                controller.transportControls.pause()
            }
        }
    }
}
