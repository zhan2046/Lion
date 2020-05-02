package com.future.media

import android.app.Application
import android.content.Context
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.audio.AudioAttributes
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector

class MediaExoPlayerHelper private constructor() {

    companion object {

        private var INSTANCE: MediaExoPlayerHelper? = null
        private lateinit var APPLICATION: Application

        @JvmStatic
        fun init(context: Application) {
            APPLICATION = context
        }

        @JvmStatic
        fun get() =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: MediaExoPlayerHelper()
                    .also { INSTANCE = it }
            }
    }

    val simpleExoPlayer: SimpleExoPlayer by lazy {
        createSimpleExoPlayer(APPLICATION).also {
            it.setAudioAttributes(uAmpAudioAttributes, true)
        }
    }

    private val uAmpAudioAttributes = AudioAttributes.Builder()
        .setContentType(C.CONTENT_TYPE_MUSIC)
        .setUsage(C.USAGE_MEDIA)
        .build()

    private fun createSimpleExoPlayer(context: Context): SimpleExoPlayer {
        val defaultRenderersFactory = DefaultRenderersFactory(context)
        defaultRenderersFactory.setExtensionRendererMode(DefaultRenderersFactory.EXTENSION_RENDERER_MODE_ON)
        return SimpleExoPlayer.Builder(context, defaultRenderersFactory).build()
    }

    fun getCurrentPosition(): Long {
        var currentPosition = 0L
        currentPosition = simpleExoPlayer.currentPosition
        return currentPosition
    }

    fun getDuration(): Long {
        var duration = 0L
        duration = simpleExoPlayer.duration
        return duration
    }

    fun getPlayWhenReady(): Boolean {
        var playWhenReady = false
        playWhenReady = simpleExoPlayer.playWhenReady
        return playWhenReady
    }

    fun getPlaybackState(): Int {
        var playbackState = 0
        playbackState = simpleExoPlayer.playbackState
        return playbackState
    }

    fun addListener(listener: Player.EventListener) {
        this.simpleExoPlayer.addListener(listener)
    }

    fun removeListener(listener: Player.EventListener) {
        this.simpleExoPlayer.removeListener(listener)
    }
}