package com.ruzhan.movie.source

import com.ruzhan.lion.model.HttpResult
import com.ruzhan.lion.model.Movie
import com.ruzhan.lion.model.MovieDetail

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface MovieApi {

    @GET("movie/{pageFileName}")
    fun getMovieList(@Path("pageFileName") pageFileName: String): Single<HttpResult<List<Movie>>>

    @GET("movie/detail/{detailFile}")
    fun getMovieDetail(@Path("detailFile") detailFile: String): Single<HttpResult<MovieDetail>>

    companion object {

        const val HOST = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/"
    }
}
