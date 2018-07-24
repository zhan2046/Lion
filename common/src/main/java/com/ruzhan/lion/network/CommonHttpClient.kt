package com.ruzhan.lion.network

import okhttp3.OkHttpClient

/**
 * Created by ruzhan123 on 2018/7/24.
 */
class CommonHttpClient private constructor() {

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()

    companion object {

        private var httpClient: CommonHttpClient? = null

        fun get(): CommonHttpClient? {
            if (httpClient == null) {
                synchronized(CommonHttpClient::class.java) {
                    if (httpClient == null) {
                        httpClient = CommonHttpClient()
                    }
                }
            }
            return httpClient
        }

        @JvmStatic
        fun getCommonHttpClient(): OkHttpClient = get()!!.okHttpClient
    }
}
