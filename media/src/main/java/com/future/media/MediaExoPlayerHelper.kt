package com.future.media

import android.content.Context
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.audio.AudioAttributes
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector

class MediaExoPlayerHelper private constructor() {

    companion object {

        private var INSTANCE: MediaExoPlayerHelper? = null

        @JvmStatic
        fun get() =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: MediaExoPlayerHelper()
                            .also { INSTANCE = it }
                }
    }

    private var simpleExoPlayer: SimpleExoPlayer? = null

    private val uAmpAudioAttributes = AudioAttributes.Builder()
            .setContentType(C.CONTENT_TYPE_MUSIC)
            .setUsage(C.USAGE_MEDIA)
            .build()

    fun initSimpleExoPlayer(context: Context) {
        var simpleExoPlayer = simpleExoPlayer
        if (simpleExoPlayer == null) {
            val defaultRenderersFactory = DefaultRenderersFactory(context)
            defaultRenderersFactory.setExtensionRendererMode(DefaultRenderersFactory.EXTENSION_RENDERER_MODE_ON)
            simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(context, defaultRenderersFactory,
                    DefaultTrackSelector()).apply {
                setAudioAttributes(uAmpAudioAttributes, true)
            }
            this.simpleExoPlayer = simpleExoPlayer
        }
    }

    fun getSimpleExoPlayer(): SimpleExoPlayer? = simpleExoPlayer

    fun releaseSimpleExoPlayer() {
        simpleExoPlayer = null
    }

    fun getCurrentPosition(): Long {
        var currentPosition = 0L
        val simpleExoPlayer = simpleExoPlayer
        if (simpleExoPlayer != null) {
            currentPosition = simpleExoPlayer.currentPosition
        }
        return currentPosition
    }

    fun getDuration(): Long {
        var duration = 0L
        val simpleExoPlayer = simpleExoPlayer
        if (simpleExoPlayer != null) {
            duration = simpleExoPlayer.duration
        }
        return duration
    }

    fun getPlayWhenReady(): Boolean {
        var playWhenReady = false
        val simpleExoPlayer = simpleExoPlayer
        if (simpleExoPlayer != null) {
            playWhenReady = simpleExoPlayer.playWhenReady
        }
        return playWhenReady
    }

    fun getPlaybackState(): Int {
        var playbackState = 0
        val simpleExoPlayer = simpleExoPlayer
        if (simpleExoPlayer != null) {
            playbackState = simpleExoPlayer.playbackState
        }
        return playbackState
    }

    fun addListener(listener: Player.EventListener) {
        this.simpleExoPlayer?.addListener(listener)
    }

    fun removeListener(listener: Player.EventListener) {
        this.simpleExoPlayer?.removeListener(listener)
    }
}