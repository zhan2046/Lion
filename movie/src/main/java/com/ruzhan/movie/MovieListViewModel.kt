package com.ruzhan.movie

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.ruzhan.lion.model.LoadStatus
import com.ruzhan.lion.model.Movie
import com.ruzhan.lion.model.RequestStatus
import com.ruzhan.lion.rx.Subscriber
import com.ruzhan.lion.util.LionUtils
import com.ruzhan.movie.network.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by ruzhan123 on 2018/7/4.
 */
class MovieListViewModel(app: Application) : AndroidViewModel(app) {

    private val requestStatus: RequestStatus<List<Movie>> = RequestStatus()

    val loadStatusLiveData: MutableLiveData<LoadStatus> = MutableLiveData()
    val requestStatusLiveData: MutableLiveData<RequestStatus<List<Movie>>> = MutableLiveData()

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
                }
                .subscribe(Subscriber.create())
    }
}