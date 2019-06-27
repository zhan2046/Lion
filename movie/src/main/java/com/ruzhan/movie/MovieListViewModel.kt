package com.ruzhan.movie

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.ruzhan.lion.db.entity.MovieEntity
import com.ruzhan.lion.db.helper.MovieEntityHelper
import com.ruzhan.lion.model.Movie
import com.ruzhan.lion.rx.Subscriber
import com.ruzhan.lion.util.LionUtils
import com.ruzhan.movie.network.MovieRepository
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class MovieListViewModel(app: Application) : AndroidViewModel(app) {

    companion object {

        private const val REFRESH = "REFRESH"
        private const val LOAD_MORE = "LOAD_MORE"

        private const val START_PAGE = 1
    }

    val loadStatusLiveData = MutableLiveData<Boolean>()
    val refreshLiveData = MutableLiveData<List<Movie>>()
    val loadMoreLiveData = MutableLiveData<List<Movie>>()

    private var isLoading = false
    private var loadPage = START_PAGE
    private var disposable: Disposable? = null
    private var localFlowable: Flowable<Any>? = null

    init {
        localFlowable = Flowable.create<Any>({ e ->
            val movieList = refreshLiveData.value
            if (movieList != null) {
                val movieEntityList: List<MovieEntity> = MovieEntityHelper.toMovieEntityList(movieList)
                MovieRepository.get().insertMovieEntityList(movieEntityList)
            }
            e.onComplete()
        }, BackpressureStrategy.LATEST)
    }

    fun loadMovieEntityList() {
        disposable = MovieRepository.get().loadMovieEntityList()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { throwable -> throwable.printStackTrace() }
                .doOnSubscribe {}
                .doFinally {}
                .doOnNext { movieEntityList ->
                    val movieList: List<Movie> = MovieEntityHelper.toMovieList(movieEntityList)
                    if (refreshLiveData.value == null) {
                        refreshLiveData.value = movieList
                    }
                    disposable?.dispose()
                }
                .subscribe({ }, { })
    }

    fun getRefreshMovieList() {
        getMovieList(REFRESH)
    }

    fun getLoadMoreMovieList() {
        getMovieList(LOAD_MORE)
    }

    private fun getMovieList(status: String) {
        if (isLoading) {
            return
        }
        isLoading = true
        when (status) {
            REFRESH -> loadPage = START_PAGE
            LOAD_MORE -> loadPage = ++loadPage
            else -> {
                // do nothing
            }
        }
        val pageFileName = loadPage.toString().plus(LionUtils.JSON_FILE)
        MovieRepository.get().getMovieList(pageFileName)
                .map { result -> result.data }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {}
                .doOnSubscribe {}
                .doFinally {
                    loadStatusLiveData.value = false
                    isLoading = false
                }
                .doOnSuccess { movieList ->
                    when (status) {
                        REFRESH -> {
                            refreshLiveData.value = movieList
                            movieList?.let { insertMovieEntityList() }
                        }
                        LOAD_MORE -> {
                            loadMoreLiveData.value = movieList
                        }
                        else -> {
                            // do nothing
                        }
                    }
                }
                .subscribe(Subscriber.create())
    }

    private fun insertMovieEntityList() {
        val localFlowable = localFlowable
        if (localFlowable != null) {
            localFlowable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnError { throwable -> throwable.printStackTrace() }
                    .doOnComplete { }
                    .subscribe(Subscriber.create())
        }
    }
}