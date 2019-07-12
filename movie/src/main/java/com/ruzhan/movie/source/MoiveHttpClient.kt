package com.ruzhan.movie.source

import okhttp3.OkHttpClient

class MoiveHttpClient private constructor() {

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()

    companion object {

        private var INSTANCE: MoiveHttpClient? = null

        fun get(): MoiveHttpClient = INSTANCE
                ?: synchronized(MoiveHttpClient::class) {
            INSTANCE
                    ?: MoiveHttpClient().also { INSTANCE = it }
        }

        @JvmStatic
        fun getCommonHttpClient(): OkHttpClient = get().okHttpClient
    }
}
