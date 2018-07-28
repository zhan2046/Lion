package com.ruzhan.lion.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.crashlytics.android.Crashlytics
import com.ruzhan.lion.BuildConfig
import com.ruzhan.lion.R
import com.ruzhan.lion.ui.home.HomeFragment
import com.ruzhan.lion.util.LionUtils
import io.fabric.sdk.android.Fabric

class MainActivity : AppCompatActivity() {

    private var homeFragment: HomeFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (BuildConfig.BUILD_TYPE.equals(LionUtils.RELEASE)) {
            Fabric.with(this, Crashlytics())
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
