package com.ruzhan.movie.network

import com.ruzhan.movie.model.HttpResult
import com.ruzhan.movie.model.Movie
import com.ruzhan.movie.model.MovieDetail

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface MovieApi {

    @GET("movie/{pageFileName}")
    fun getMovieList(@Path("pageFileName") pageFileName: String): Single<HttpResult<List<Movie>>>

    @GET("movie/detail/{detailFile}")
    fun getMovieDetail(@Path("detailFile") detailFile: String): Single<HttpResult<MovieDetail>>

    companion object {

        const val HOST = "https://raw.githubusercontent.com/ruzhan123/Movie/master/json/api/"
    }
}
