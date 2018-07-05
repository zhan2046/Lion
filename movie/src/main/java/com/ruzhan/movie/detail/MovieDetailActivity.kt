package com.ruzhan.movie.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ruzhan.movie.R

/**
 * Created by ruzhan123 on 2018/7/5.
 */
class MovieDetailActivity : AppCompatActivity() {

    companion object {

        private const val MOVIE_ID: String = "MOVIE_ID"

        @JvmStatic
        fun launch(activity: Activity, movieId: String) {
            val intent = Intent(activity, MovieDetailActivity::class.java)
            intent.putExtra(MOVIE_ID, movieId)
            activity.startActivity(intent)
        }
    }

    private var movieDetailFragment: MovieDetailFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container)

        val movieId = intent.getStringExtra(MOVIE_ID)

        if (movieDetailFragment == null) {
            movieDetailFragment = MovieDetailFragment.newInstance(movieId)
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container, movieDetailFragment, "MovieDetailFragment")
                    .commit()
        }
    }

}