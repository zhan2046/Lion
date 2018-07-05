package com.ruzhan.movie.detail

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import com.ruzhan.lion.App
import com.ruzhan.lion.glide.ImageLoader
import com.ruzhan.lion.model.Movie
import com.ruzhan.movie.R
import kotlinx.android.synthetic.main.frag_movie_detail.*

/**
 * Created by ruzhan123 on 2018/7/5.
 */
class MovieDetailFragment : Fragment() {

    companion object {

        private const val MOVIE: String = "MOVIE"

        @JvmStatic
        fun newInstance(movie: Movie): MovieDetailFragment {
            val args = Bundle()
            args.putParcelable(MOVIE, movie)
            val frag = MovieDetailFragment()
            frag.arguments = args
            return  frag
        }
    }

    private lateinit var movie: Movie
    private val movieDetailViewModel: MovieDetailViewModel = MovieDetailViewModel(App.get())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movie = arguments!!.getParcelable(MOVIE)
        movie.image?.let { ImageLoader.get().load(shot, it) }

        shot.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                shot.viewTreeObserver.removeOnPreDrawListener(this)
                startPostponedEnterTransition()
                return true
            }
        })

        movieDetailViewModel.movieDetailLiveData.observe(this@MovieDetailFragment,
                Observer { movieDetail ->
                   
        })

        movieDetailViewModel.getMovieDetail(movie.id!!)
    }
}