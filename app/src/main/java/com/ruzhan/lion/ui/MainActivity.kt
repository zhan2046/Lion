package com.ruzhan.lion.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ruzhan.lion.R
import com.ruzhan.lion.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {

    private var homeFragment: HomeFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (homeFragment == null) {
            homeFragment = HomeFragment.newInstance()
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container, homeFragment, "homeFragment")
                    .commit()
        }
    }
}
