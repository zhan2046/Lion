package com.ruzhan.movie.network;

import okhttp3.OkHttpClient;

/**
 * Created by ruzhan123 on 2018/7/4.
 */
public class MovieHttpClient {

    private static MovieHttpClient movieHttpClient;

    private OkHttpClient okHttpClient;

    public static MovieHttpClient get() {
        if (movieHttpClient == null) {
            synchronized (MovieHttpClient.class) {
                if (movieHttpClient == null) {
                    movieHttpClient = new MovieHttpClient();
                }
            }
        }
        return movieHttpClient;
    }

    private MovieHttpClient() {
        okHttpClient = new OkHttpClient.Builder().build();
    }

    public static OkHttpClient getMovieHttpClient() {
        return get().okHttpClient;
    }
}
