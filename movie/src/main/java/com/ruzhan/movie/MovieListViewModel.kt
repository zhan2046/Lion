package com.ruzhan.movie

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ruzhan.lion.database.CommonModel
import com.ruzhan.lion.model.Movie
import com.ruzhan.lion.rx.Subscriber
import com.ruzhan.lion.util.LionUtils
import com.ruzhan.movie.network.MovieRepository
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class MovieListViewModel(app: Application) : AndroidViewModel(app) {

    companion object {

        private const val REFRESH = "REFRESH"
        private const val LOAD_MORE = "LOAD_MORE"

        private const val DEBOUNCE_TIME = 1000L
        private const val LION_MOVIE_LIST = 3000
        private const val START_PAGE = 1
    }

    val loadStatusLiveData = MutableLiveData<Boolean>()
    val refreshLiveData = MutableLiveData<List<Movie>>()
    val loadMoreLiveData = MutableLiveData<List<Movie>>()

    private var isLoading = false
    private var loadPage = START_PAGE
    private var disposable: Disposable? = null
    private var localDisposable: Disposable? = null
    private var localFlowable: Flowable<Any>? = null

    private val gson = Gson()

    init {
        localFlowable = Flowable.create<Any>({ e ->
            val movieList = refreshLiveData.value
            if (movieList != null) {
                val jsonStr = gson.toJson(movieList)
                val commonModel = CommonModel(LION_MOVIE_LIST, jsonStr)
                MovieRepository.get().insertCommonModel(commonModel)
            }
            e.onComplete()
        }, BackpressureStrategy.LATEST)
    }

    fun getLocalMovieList() {
        disposable = MovieRepository.get().getCommonModel(LION_MOVIE_LIST)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { throwable -> throwable.printStackTrace() }
                .doOnSubscribe {}
                .doFinally {}
                .doOnNext { commonModel ->
                    if (commonModel != null) {
                        val content = commonModel.content
                        if (content.isNotBlank()) {
                            val movieList: List<Movie> = gson.fromJson(content,
                                    object : TypeToken<List<Movie>>() {}.type)
                            if (refreshLiveData.value == null) {
                                refreshLiveData.value = movieList
                            }
                        }
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
            localDisposable = localFlowable.debounce(DEBOUNCE_TIME, TimeUnit.MILLISECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnError { throwable -> throwable.printStackTrace() }
                    .doOnComplete { localDisposable?.dispose() }
                    .subscribe({ }, { })
        }
    }
}