package com.ruzhan.movie

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.blankj.utilcode.util.LogUtils
import com.ruzhan.lion.db.entity.MovieEntity
import com.ruzhan.lion.db.helper.MovieEntityHelper
import com.ruzhan.lion.model.LoadStatus
import com.ruzhan.lion.model.Movie
import com.ruzhan.lion.model.RequestStatus
import com.ruzhan.lion.rx.Subscriber
import com.ruzhan.lion.util.LionUtils
import com.ruzhan.movie.network.MovieRepository
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class MovieListViewModel(app: Application) : AndroidViewModel(app) {

    private val TAG: String = "MovieListViewModel"

    private val requestStatus: RequestStatus<List<Movie>> = RequestStatus()

    val loadStatusLiveData: MutableLiveData<LoadStatus> = MutableLiveData()
    val requestStatusLiveData: MutableLiveData<RequestStatus<List<Movie>>> = MutableLiveData()

    private var disposable: Disposable? = null

    init {
        requestStatusLiveData.value = null
    }

    fun loadMovieEntityList() {
        LogUtils.iTag(TAG, "loadMovieEntityList called...")

        disposable = MovieRepository.get().loadMovieEntityList()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { throwable -> LogUtils.iTag(TAG, "loadMovieEntityList error... " + throwable.toString()) }
                .doOnSubscribe {}
                .doFinally {}
                .doOnNext { movieEntityList ->
                    LogUtils.iTag(TAG, "loadMovieEntityList doOnNext... movieEntityList.size: " + movieEntityList.size)

                    val movieList: List<Movie> = MovieEntityHelper.toMovieList(movieEntityList)
                    if (requestStatusLiveData.value == null) {
                        requestStatus.refreshStatus = RequestStatus.REFRESH
                        requestStatus.data = movieList
                        requestStatusLiveData.value = requestStatus
                    }
                    disposable?.dispose()
                }
                .subscribe({ }, { })
    }

    fun getMovieList(refreshStatus: Int) {
        if (requestStatus.isNetworkRequest) return

        requestStatus.isNetworkRequest = true

        requestStatus.refreshStatus = refreshStatus
        requestStatus.setPage(refreshStatus)

        val pageFileName = requestStatus.page.toString().plus(LionUtils.JSON_FILE)

        MovieRepository.get().getMovieList(pageFileName)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {}
                .doOnSubscribe {
                    if (RequestStatus.REFRESH == requestStatus.refreshStatus) {
                        loadStatusLiveData.value = LoadStatus.LOADING
                    }
                }
                .map { result -> result.data }
                .doFinally {
                    loadStatusLiveData.value = LoadStatus.LOADED
                    requestStatus.isNetworkRequest = false
                }
                .doOnSuccess { movieList ->
                    requestStatus.data = movieList
                    requestStatusLiveData.value = requestStatus

                    movieList?.let { insertMovieEntityList(movieList) }
                }
                .subscribe(Subscriber.create())
    }

    private fun insertMovieEntityList(movieList: List<Movie>) {
        Flowable.create<Any>({ e ->
            val movieEntityList: List<MovieEntity> = MovieEntityHelper.toMovieEntityList(movieList)
            LogUtils.iTag(TAG, "insertMovieEntityList called... movieEntityList.size: " + movieEntityList.size)
            MovieRepository.get().insertMovieEntityList(movieEntityList)
            e.onComplete()

        }, BackpressureStrategy.LATEST)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { throwable -> LogUtils.iTag(TAG, "insertMovieEntityList doOnError... " + throwable.toString()) }
                .doOnComplete { LogUtils.iTag(TAG, "insertMovieEntityList doOnComplete...") }
                .subscribe(Subscriber.create())
    }
}