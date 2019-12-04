package com.ruzhan.movie.network

import com.ruzhan.lion.database.CommonAppDatabase
import com.ruzhan.lion.database.CommonModel
import com.ruzhan.lion.model.HttpResult
import com.ruzhan.lion.model.MovieDetail
import com.ruzhan.lion.util.ResUtils
import com.ruzhan.movie.db.MovieDatabase
import com.ruzhan.movie.db.entity.MovieEntity
import com.ruzhan.movie.helper.MovieHelper
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
    private val commonAppDatabase: CommonAppDatabase by lazy {
        CommonAppDatabase.invoke(ResUtils.getApp())
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

    fun getMovieDetail(detailFile: String): Single<HttpResult<MovieDetail>> {
        return api.getMovieDetail(detailFile).subscribeOn(Schedulers.io())
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

    fun insertCommonModel(commonModel: CommonModel) {
        commonAppDatabase.commonDao().insertCommonModel(commonModel)
    }

    fun getCommonModel(id: Int): Flowable<CommonModel> {
        return commonAppDatabase.commonDao().getCommonModel(id)
    }
}
