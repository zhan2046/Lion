package com.ruzhan.movie.detail

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.ruzhan.lion.model.MovieDetail
import com.ruzhan.lion.rx.Subscriber
import com.ruzhan.lion.util.LionUtils
import com.ruzhan.movie.network.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by ruzhan123 on 2018/7/4.
 */
class MovieDetailViewModel(app: Application) : AndroidViewModel(app) {

    var movieDetailLiveData: MutableLiveData<MovieDetail> = MutableLiveData()

    fun getMovieDetail(movieId: String) {
        val detailFile = movieId.plus(LionUtils.JSON_FILE)
        MovieRepository.get().getMovieDetail(detailFile)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {}
                .doOnSubscribe {}
                .map { result -> result.data }
                .doFinally {}
                .doOnSuccess { movieDetail -> movieDetailLiveData.value = movieDetail }
                .subscribe(Subscriber.create())
    }
}