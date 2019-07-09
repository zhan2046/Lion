package com.ruzhan.lion.network

import okhttp3.OkHttpClient

class CommonHttpClient private constructor() {

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()

    companion object {

        private var INSTANCE: CommonHttpClient? = null

        fun get(): CommonHttpClient = INSTANCE ?: synchronized(CommonHttpClient::class) {
            INSTANCE ?: CommonHttpClient().also { INSTANCE = it }
        }

        @JvmStatic
        fun getCommonHttpClient(): OkHttpClient = get().okHttpClient
    }
}
