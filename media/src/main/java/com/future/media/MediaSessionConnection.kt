package com.future.media

import android.content.ComponentName
import android.content.Context
import android.os.Bundle
import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.MediaControllerCompat
import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat
import androidx.lifecycle.MutableLiveData
import com.google.android.exoplayer2.Player
import com.future.media.model.MediaPlayerState

class MediaSessionConnection(context: Context, serviceComponent: ComponentName) {

    companion object {

        @Volatile
        private var instance: MediaSessionConnection? = null

        @JvmStatic
        fun getInstance(context: Context, serviceComponent: ComponentName) =
                instance ?: synchronized(this) {
                    instance ?: MediaSessionConnection(context, serviceComponent)
                            .also { instance = it }
                }

        @JvmStatic
        fun get(context: Context): MediaSessionConnection {
            return getInstance(context,
                    ComponentName(context, MediaService::class.java))
        }
    }

    private val mediaBrowserConnectionCallback = MediaBrowserConnectionCallback(context)
    val mediaBrowser = MediaBrowserCompat(context, serviceComponent,
            mediaBrowserConnectionCallback, null)
    var mediaController: MediaControllerCompat? = null

    val isConnected: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
    val playbackState: MutableLiveData<PlaybackStateCompat> by lazy {
        MutableLiveData<PlaybackStateCompat>()
    }
    val nowPlaying: MutableLiveData<MediaMetadataCompat> by lazy {
        MutableLiveData<MediaMetadataCompat>()
    }
    val nowNotNullPlaying: MutableLiveData<MediaMetadataCompat> by lazy {
        MutableLiveData<MediaMetadataCompat>()
    }

    private val playerEventListener = PlayerEventListener()
    private val mediaPlayerState: MediaPlayerState by lazy {
        MediaPlayerState(false, Player.STATE_IDLE)
    }
    val mediaPlayerStateLiveData: MutableLiveData<MediaPlayerState> by lazy {
        MutableLiveData<MediaPlayerState>()
    }
    val mediaReasonLiveData: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    var mediaRepeatMode = PlaybackStateCompat.REPEAT_MODE_NONE

    init {
        isConnected.postValue(false)
        mediaBrowser.connect()
    }

    fun getTransportControls(): MediaControllerCompat.TransportControls? {
        return mediaController?.transportControls
    }

    fun subscribe(parentId: String, callback: MediaBrowserCompat.SubscriptionCallback) {
        mediaBrowser.subscribe(parentId, callback)
    }

    fun unsubscribe(parentId: String, callback: MediaBrowserCompat.SubscriptionCallback) {
        mediaBrowser.unsubscribe(parentId, callback)
    }

    fun showMediaNotification() {
        MediaCommand.get().setNotificationCommand(MediaCommand.NOTIFICATION_STATUS_SHOW)
        mediaController?.sendCommand(MediaCommand.NOTIFICATION_STATUS_SHOW, null, null)
    }

    fun hideMediaNotification() {
        MediaCommand.get().setNotificationCommand(MediaCommand.NOTIFICATION_STATUS_HIDE)
        mediaController?.sendCommand(MediaCommand.NOTIFICATION_STATUS_HIDE, null, null)
    }

    fun isNotificationStatusShow(): Boolean = MediaCommand.get().isNotificationStatusShow()

    fun isNotificationStatusHide(): Boolean = MediaCommand.get().isNotificationStatusHide()

    private inner class MediaBrowserConnectionCallback(private val context: Context)
        : MediaBrowserCompat.ConnectionCallback() {

        override fun onConnected() {
            val mediaController = MediaControllerCompat(context, mediaBrowser.sessionToken)
            this@MediaSessionConnection.mediaController = mediaController
            mediaController.registerCallback(MediaControllerCallback())
            MediaExoPlayerHelper.get().addListener(playerEventListener)
            isConnected.postValue(true)
        }

        override fun onConnectionSuspended() {
            isConnected.postValue(false)
        }

        override fun onConnectionFailed() {
            isConnected.postValue(false)
        }
    }

    private inner class MediaControllerCallback : MediaControllerCompat.Callback() {

        override fun onSessionEvent(event: String?, extras: Bundle?) {
            // do nothing
        }

        override fun onPlaybackStateChanged(state: PlaybackStateCompat?) {
            playbackState.postValue(state)
            if (state != null && state.state == PlaybackStateCompat.STATE_PLAYING) {
                mediaController?.transportControls?.setRepeatMode(mediaRepeatMode)
            }
        }

        override fun onMetadataChanged(metadata: MediaMetadataCompat?) {
            nowPlaying.postValue(metadata)
            if (metadata != null) {
                nowNotNullPlaying.postValue(metadata)
            }
        }

        override fun onQueueChanged(queue: MutableList<MediaSessionCompat.QueueItem>?) {
            // do nothing
        }

        override fun onSessionDestroyed() {
            mediaBrowserConnectionCallback.onConnectionSuspended()
        }
    }

    private inner class PlayerEventListener : Player.EventListener {

        override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
            mediaPlayerState.playWhenReady = playWhenReady
            mediaPlayerState.playbackState = playbackState
            mediaPlayerStateLiveData.value = mediaPlayerState
        }

        override fun onPositionDiscontinuity(reason: Int) {
            mediaReasonLiveData.value = reason
        }
    }
}