package com.ruzhan.movie.network

import com.ruzhan.lion.model.HttpResult
import com.ruzhan.lion.model.Movie

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

/**
 * Created by ruzhan123 on 2018/7/4.
 */
class MovieRepository {

    private val api: MovieApi = MovieClient.get()

    fun getMovieList(pageFileName: String): Single<HttpResult<List<Movie>>> {
        return api.getMovieList(pageFileName).subscribeOn(Schedulers.io())
    }

    companion object {

        private var INSTANCE: MovieRepository? = null

        fun get(): MovieRepository {
            if (INSTANCE == null) {
                synchronized(MovieRepository::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = MovieRepository()
                    }
                }
            }
            return this.INSTANCE!!
        }
    }
}
