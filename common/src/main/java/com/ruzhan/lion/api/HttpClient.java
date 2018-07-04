package com.ruzhan.lion.api;

import okhttp3.OkHttpClient;

/**
 * Created by ruzhan123 on 2018/7/4.
 */
public class HttpClient {

    private static HttpClient httpClient;

    private OkHttpClient okHttpClient;

    public static HttpClient get() {
        if (httpClient == null) {
            synchronized (HttpClient.class) {
                if (httpClient == null) {
                    httpClient = new HttpClient();
                }
            }
        }
        return httpClient;
    }

    private HttpClient() {
        okHttpClient = new OkHttpClient.Builder().build();
    }

    public static OkHttpClient getHttpClient() {
        return get().okHttpClient;
    }
}
