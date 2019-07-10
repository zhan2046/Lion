package com.ruzhan.movie.detail.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ruzhan.lion.database.CommonModel
import com.ruzhan.lion.model.MovieDetail
import com.ruzhan.lion.rx.Subscriber
import com.ruzhan.lion.util.LionUtils
import com.ruzhan.movie.source.MovieRepository
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MovieDetailViewModel(app: Application) : AndroidViewModel(app) {

    var movieDetailLiveData: MutableLiveData<MovieDetail> = MutableLiveData()

    private var localFlowable: Flowable<Any>? = null
    private var disposable: Disposable? = null
    private var localDisposable: Disposable? = null

    var movieId = ""
    private val gson = Gson()

    init {
        localFlowable = Flowable.create<Any>({ e ->
            handleInsertCommonModel()
            e.onComplete()
        }, BackpressureStrategy.LATEST)
    }

    private fun handleInsertCommonModel() {
        val movieDetail = movieDetailLiveData.value
        if (movieDetail != null) {
            val jsonStr = gson.toJson(movieDetail)
            val commonModel = CommonModel(movieId.toInt(), jsonStr)
            MovieRepository.get().insertCommonModel(commonModel)
        }
    }

    fun getLocalMovieDetail(movieId: String) {
        disposable = MovieRepository.get().getCommonModel(movieId.toInt())
                .map { commonModel -> commonModelToMovieDetail(commonModel) }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { throwable -> throwable.printStackTrace() }
                .doOnSubscribe { }
                .doFinally { }
                .doOnNext { movieDetail -> handleLocalMovieDetail(movieDetail) }
                .subscribe({ }, { })
    }

    private fun handleLocalMovieDetail(movieDetail: MovieDetail) {
        if (movieDetailLiveData.value == null) {
            movieDetailLiveData.value = movieDetail
        }
        disposable?.dispose()
    }

    private fun commonModelToMovieDetail(commonModel: CommonModel): MovieDetail {
        var movieDetail = MovieDetail.empty()
        val content = commonModel.content
        if (content.isNotBlank()) {
            movieDetail = gson.fromJson(content, object : TypeToken<MovieDetail>() {}.type)
        }
        return movieDetail
    }

    fun getMovieDetail(movieId: String) {
        val detailFile = movieId.plus(LionUtils.JSON_FILE)
        MovieRepository.get().getMovieDetail(detailFile)
                .map { result -> result.data }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {}
                .doOnSubscribe {}
                .doFinally {}
                .doOnSuccess { movieDetail -> handleMovieDetail(movieDetail) }
                .subscribe(Subscriber.create())
    }

    private fun handleMovieDetail(movieDetail: MovieDetail?) {
        movieDetailLiveData.value = movieDetail
        insertLocalMovieDetail()
    }

    private fun insertLocalMovieDetail() {
        val localFlowable = localFlowable
        if (localFlowable != null) {
            localDisposable = localFlowable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnError { throwable -> throwable.printStackTrace() }
                    .doOnComplete { localDisposable?.dispose() }
                    .subscribe({ }, { })
        }
    }
}