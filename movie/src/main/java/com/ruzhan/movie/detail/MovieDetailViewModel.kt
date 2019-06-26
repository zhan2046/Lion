package com.ruzhan.movie.detail

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.blankj.utilcode.util.LogUtils
import com.ruzhan.lion.db.entity.MovieDetailEntity
import com.ruzhan.lion.db.helper.MovieDetailEntityHelper
import com.ruzhan.lion.model.MovieDetail
import com.ruzhan.lion.rx.Subscriber
import com.ruzhan.lion.util.LionUtils
import com.ruzhan.movie.network.MovieRepository
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MovieDetailViewModel(app: Application) : AndroidViewModel(app) {

    private val TAG: String = "MovieDetailViewModel"

    var movieDetailLiveData: MutableLiveData<MovieDetail> = MutableLiveData()

    private var disposable: Disposable? = null

    init {
        movieDetailLiveData.value = null
    }

    fun loadMovieDetailEntity(movieId: String) {
        disposable = MovieRepository.get().loadMovieDetailEntity(movieId)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { throwable -> LogUtils.iTag(TAG, "loadMovieDetailEntity error... " + throwable.toString()) }
                .doOnSubscribe {}
                .doFinally {}
                .doOnNext { movieDetailEntity ->
                    LogUtils.iTag(TAG, "loadMovieDetailEntity doOnNext...")

                    val movieList: MovieDetail = MovieDetailEntityHelper.toMovieDetail(movieDetailEntity)
                    if (movieDetailLiveData.value == null) {
                        movieDetailLiveData.value = movieList
                    }
                    disposable?.dispose()
                }
                .subscribe({ }, { })
    }

    fun getMovieDetail(movieId: String) {
        val detailFile = movieId.plus(LionUtils.JSON_FILE)
        MovieRepository.get().getMovieDetail(detailFile)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {}
                .doOnSubscribe {}
                .map { result -> result.data }
                .doFinally {}
                .doOnSuccess { movieDetail ->
                    movieDetailLiveData.value = movieDetail

                    movieDetail?.let { insertMovieDetailEntity(movieDetail) }
                }
                .subscribe(Subscriber.create())
    }

    private fun insertMovieDetailEntity(movieDetail: MovieDetail) {
        Flowable.create<Any>({ e ->
            val movieDetailEntity: MovieDetailEntity = MovieDetailEntityHelper.toMovieDetailEntity(movieDetail)
            LogUtils.iTag(TAG, "insertMovieDetailEntity called...")
            MovieRepository.get().insertMovieDetailEntity(movieDetailEntity)
            e.onComplete()

        }, BackpressureStrategy.LATEST)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { throwable -> LogUtils.iTag(TAG, "insertMovieDetailEntity doOnError... " + throwable.toString()) }
                .doOnComplete { LogUtils.iTag(TAG, "insertMovieDetailEntity doOnComplete...") }
                .subscribe(Subscriber.create())
    }

}