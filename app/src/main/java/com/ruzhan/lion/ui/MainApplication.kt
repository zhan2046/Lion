package com.ruzhan.lion.ui

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.ruzhan.font.FontHelper
import com.ruzhan.movie.utils.ResUtils
import com.ruzhan.movie.utils.X5Helper


class MainApplication : Application() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        ResUtils.init(this)
        FontHelper.init(this)
        X5Helper.init(this)
    }
}
