package com.ruzhan.lion.ui

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.multidex.MultiDex
import com.lion.font.FontHelper
import com.ruzhan.lion.util.ResUtils
import com.ruzhan.movie.utils.X5Helper
import com.tencent.smtt.sdk.QbSdk


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
