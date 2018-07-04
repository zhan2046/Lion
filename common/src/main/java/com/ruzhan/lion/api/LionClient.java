package com.ruzhan.lion.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ruzhan123 on 2018/7/4.
 */
public class LionClient {

    private static volatile LionApi api;

    private LionClient() {

    }

    public static LionApi get() {
        if (api == null) {
            synchronized (LionClient.class) {
                if (api == null) {
                    Retrofit client = new Retrofit.Builder().baseUrl(LionApi.HOST)
                            .client(HttpClient.getHttpClient())
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                    api = client.create(LionApi.class);
                }
            }
        }
        return api;
    }
}
