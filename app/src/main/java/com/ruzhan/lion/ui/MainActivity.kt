package com.ruzhan.lion.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ruzhan.lion.R
import com.ruzhan.lion.ui.home.HomeFragment
import com.ruzhan.movie.MovieListFragment
import com.ruzhan.movie.detail.MovieDetailActivity

class MainActivity : AppCompatActivity() {

    private var homeFragment: HomeFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container)

        if (homeFragment == null) {
            homeFragment = HomeFragment.newInstance()
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container, homeFragment, "homeFragment")
                    .commit()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == MovieListFragment.MOVIE_LIST_REQUEST_CODE) {
            if (resultCode == MovieDetailActivity.MOVIE_DETAIL_RESULT_CODE) {

            }
        }
    }
}
