package com.ruzhan.movie.network

import com.ruzhan.lion.network.CommonHttpClient

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object MovieClient {

    @Volatile
    private var api: MovieApi? = null

    fun get(): MovieApi {
        if (api == null) {
            synchronized(MovieClient::class.java) {
                if (api == null) {
                    val client = Retrofit.Builder().baseUrl(MovieApi.HOST)
                            .client(CommonHttpClient.getCommonHttpClient())
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build()
                    api = client.create(MovieApi::class.java)
                }
            }
        }
        return api!!
    }
}
