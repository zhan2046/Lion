package com.ruzhan.movie.network

import com.ruzhan.movie.db.MovieDatabase
import com.ruzhan.movie.db.entity.MovieDetailEntity
import com.ruzhan.movie.db.entity.MovieEntity
import com.ruzhan.movie.helper.MovieHelper
import com.ruzhan.movie.model.HttpResult
import com.ruzhan.movie.model.MovieDetail
import com.ruzhan.movie.utils.ResUtils
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class MovieRepository private constructor() {

    companion object {

        private var INSTANCE: MovieRepository? = null

        fun get() = INSTANCE ?: synchronized(MovieRepository::class) {
            INSTANCE ?: MovieRepository().also { INSTANCE = it }
        }
    }

    private val api: MovieApi by lazy {
        MovieClient.get()
    }
    private val movieDatabase: MovieDatabase by lazy {
        MovieDatabase.get(ResUtils.getApp())
    }

    fun getMovieList(pageFileName: String): Single<List<MovieEntity>> {
        return api.getMovieList(pageFileName)
                .subscribeOn(Schedulers.io())
                .map { result ->
                    val movieEntityList =
                            MovieHelper.getMovieEntityList(result.data)
                    insertMovieEntityList(movieEntityList)
                    movieEntityList
                }
    }

    fun getMovieDetail(detailFile: String): Single<MovieDetailEntity> {
        return api.getMovieDetail(detailFile)
                .subscribeOn(Schedulers.io())
                .map { result ->
                    var movieDetailEntity = MovieDetailEntity.empty()
                    val data = result.data
                    if (data != null) {
                        movieDetailEntity = MovieHelper.getMovieDetailEntity(data)
                        insertMovieDetailEntity(movieDetailEntity)
                    }
                    movieDetailEntity
                }
    }

    fun loadMovieEntityList(): Flowable<List<MovieEntity>> {
        return movieDatabase.movieDao().loadMovieEntityList()
    }

    fun loadMovieEntityList(tag: String): Flowable<List<MovieEntity>> {
        return movieDatabase.movieDao().loadMovieEntityList(tag)
    }

    private fun insertMovieEntityList(dayNewList: List<MovieEntity>) {
        movieDatabase.movieDao().insertMovieEntityList(dayNewList)
    }

    fun loadMovieDetailEntity(id: String): Flowable<MovieDetailEntity> {
        return movieDatabase.movieDetailDao().loadMovieDetailEntity(id)
    }

    private fun insertMovieDetailEntity(movieDetailEntity: MovieDetailEntity) {
        movieDatabase.movieDetailDao().insertMovieDetailEntity(movieDetailEntity)
    }
}
