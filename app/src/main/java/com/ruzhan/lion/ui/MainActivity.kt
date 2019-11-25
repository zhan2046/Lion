package com.ruzhan.lion.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ruzhan.lion.R
import com.ruzhan.movie.MovieHomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lion_container)
        if (savedInstanceState == null) {
            val homeFragment = MovieHomeFragment.newInstance()
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container, homeFragment, "movieHomeFragment")
                    .commit()
        }
    }
}
