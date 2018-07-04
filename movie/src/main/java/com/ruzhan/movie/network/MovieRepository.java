package com.ruzhan.movie.network;

import com.ruzhan.lion.model.HttpResult;
import com.ruzhan.lion.model.Movie;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ruzhan123 on 2018/7/4.
 */
public class MovieRepository {

    private static MovieRepository INSTANCE;

    private MovieApi api;

    public MovieRepository() {
        api = MovieClient.get();
    }

    public static MovieRepository get() {
        if (INSTANCE == null) {
            synchronized (MovieRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MovieRepository();
                }
            }
        }
        return INSTANCE;
    }

    public Single<HttpResult<List<Movie>>> getMovieList(String pageFileName) {
        return api.getMovieList(pageFileName).subscribeOn(Schedulers.io());
    }
}
