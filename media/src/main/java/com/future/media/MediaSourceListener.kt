package com.future.media

import com.google.android.exoplayer2.source.ConcatenatingMediaSource

interface MediaSourceListener {

    fun onMediaSourceSuccess(mediaSource: ConcatenatingMediaSource)
}