package com.ruzhan.movie.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import com.ruzhan.lion.model.Movie
import com.ruzhan.movie.R

class MovieDetailActivity : AppCompatActivity() {

    companion object {

        private const val MOVIE: String = "MOVIE"

        @JvmStatic
        fun launch(activity: Activity, movie: Movie, option: ActivityOptionsCompat) {
            val intent = Intent(activity, MovieDetailActivity::class.java)
            intent.putExtra(MOVIE, movie)
            activity.startActivity(intent, option.toBundle())
        }
    }

    private var movieDetailFragment: MovieDetailFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container)

        val movie = intent.getParcelableExtra<Movie>(MOVIE)

        if (movieDetailFragment == null) {
            movieDetailFragment = MovieDetailFragment.newInstance(movie)
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container, movieDetailFragment, "MovieDetailFragment")
                    .commit()
        }
    }

    override fun onBackPressed() {
        movieDetailFragment?.closeFragmentUpdateUi()
        finishAfterTransition()
    }
}