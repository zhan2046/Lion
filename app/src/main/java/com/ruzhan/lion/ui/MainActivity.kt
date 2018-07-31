package com.ruzhan.lion.ui

import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ruzhan.lion.R
import com.ruzhan.lion.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {

    private var homeFragment: HomeFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //android O fix bug orientation
        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        setContentView(R.layout.container)

        if (homeFragment == null) {
            homeFragment = HomeFragment.newInstance()
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container, homeFragment, "homeFragment")
                    .commit()
        }
    }
}
