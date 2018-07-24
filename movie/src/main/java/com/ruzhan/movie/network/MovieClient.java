package com.ruzhan.movie.network;

import com.ruzhan.lion.network.CommonHttpClient;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ruzhan123 on 2018/7/4.
 */
public class MovieClient {

    private static volatile MovieApi api;

    private MovieClient() {

    }

    public static MovieApi get() {
        if (api == null) {
            synchronized (MovieClient.class) {
                if (api == null) {
                    Retrofit client = new Retrofit.Builder().baseUrl(MovieApi.HOST)
                            .client(CommonHttpClient.getCommonHttpClient())
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                    api = client.create(MovieApi.class);
                }
            }
        }
        return api;
    }
}
