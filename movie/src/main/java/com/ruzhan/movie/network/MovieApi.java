package com.ruzhan.movie.network;

import com.ruzhan.lion.model.HttpResult;
import com.ruzhan.lion.model.Movie;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ruzhan123 on 2018/7/4.
 */
public interface MovieApi {

    String HOST = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/";

    @GET("movie/{pageFileName}")
    Single<HttpResult<List<Movie>>> getMovieList(@Path("pageFileName") String pageFileName);
}
