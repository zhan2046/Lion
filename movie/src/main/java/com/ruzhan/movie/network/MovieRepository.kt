package com.ruzhan.movie.network

import com.ruzhan.lion.App
import com.ruzhan.lion.database.CommonAppDatabase
import com.ruzhan.lion.database.CommonModel
import com.ruzhan.lion.db.AppDatabase
import com.ruzhan.lion.db.entity.MovieDetailEntity
import com.ruzhan.lion.db.entity.MovieEntity
import com.ruzhan.lion.model.HttpResult
import com.ruzhan.lion.model.Movie
import com.ruzhan.lion.model.MovieDetail
import io.reactivex.Flowable

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class MovieRepository private constructor() {

    private val api: MovieApi = MovieClient.get()
    private val appDatabase: AppDatabase = AppDatabase[App.get()]
    private val commonAppDatabase = CommonAppDatabase.invoke(App.get())

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

    fun loadMovieDetailEntity(movieId: String): Flowable<MovieDetailEntity> {
        return appDatabase.movieDetailEntityDao().loadMovieDetailEntity(movieId)
    }

    fun insertMovieDetailEntity(movieDetailEntity: MovieDetailEntity) {
        return appDatabase.movieDetailEntityDao().insertMovieDetailEntity(movieDetailEntity)
    }

    fun insertCommonModel(commonModel: CommonModel) {
        commonAppDatabase.commonDao().insertCommonModel(commonModel)
    }

    fun getCommonModel(id: Int): Flowable<CommonModel> {
        return commonAppDatabase.commonDao().getCommonModel(id)
    }
}
