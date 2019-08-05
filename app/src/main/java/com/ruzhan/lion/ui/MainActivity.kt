package com.ruzhan.lion.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ruzhan.lion.R
import com.ruzhan.lion.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lion_container)
        if (savedInstanceState == null) {
            val homeFragment = HomeFragment.newInstance()
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container, homeFragment, "homeFragment")
                    .commit()
        }
    }
}
