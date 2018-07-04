package com.ruzhan.movie

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.ruzhan.lion.model.Movie
import com.ruzhan.lion.rx.Subscriber
import com.ruzhan.lion.util.LionUtil
import com.ruzhan.movie.network.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by ruzhan123 on 2018/7/4.
 */
class MovieListViewModel(app: Application) : AndroidViewModel(app) {

    var movieListLiveData: MutableLiveData<List<Movie>> = MutableLiveData()

    fun getMovieList(page: Int) {
        val pageFileName = page.toString().plus(LionUtil.JSON_FILE)
        MovieRepository.get().getMovieList(pageFileName)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {}
                .doOnSubscribe {}
                .map { result -> result.data }
                .doFinally {}
                .doOnSuccess { movieList -> movieListLiveData.value = movieList }
                .subscribe(Subscriber.create())
    }
}