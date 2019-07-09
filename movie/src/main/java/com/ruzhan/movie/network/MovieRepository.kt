package com.ruzhan.movie.network

import com.ruzhan.lion.database.CommonAppDatabase
import com.ruzhan.lion.database.CommonModel
import com.ruzhan.lion.model.HttpResult
import com.ruzhan.lion.model.Movie
import com.ruzhan.lion.model.MovieDetail
import com.ruzhan.lion.util.ResUtils
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class MovieRepository private constructor() {

    private val api: MovieApi = MovieClient.get()
    private val commonAppDatabase = CommonAppDatabase.invoke(ResUtils.getApp())

    companion object {

        private var INSTANCE: MovieRepository? = null

        fun get() = INSTANCE ?: synchronized(MovieRepository::class) {
            INSTANCE ?: MovieRepository().also { INSTANCE = it }
        }
    }

    fun getMovieList(pageFileName: String): Single<HttpResult<List<Movie>>> {
        return api.getMovieList(pageFileName).subscribeOn(Schedulers.io())
    }

    fun getMovieDetail(detailFile: String): Single<HttpResult<MovieDetail>> {
        return api.getMovieDetail(detailFile).subscribeOn(Schedulers.io())
    }

    fun insertCommonModel(commonModel: CommonModel) {
        commonAppDatabase.commonDao().insertCommonModel(commonModel)
    }

    fun getCommonModel(id: Int): Flowable<CommonModel> {
        return commonAppDatabase.commonDao().getCommonModel(id)
    }
}
