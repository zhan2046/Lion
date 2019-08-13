package com.ruzhan.lion.ui

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.multidex.MultiDex
import com.lion.font.FontHelper
import com.ruzhan.lion.util.ResUtils
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
        val cb = object : QbSdk.PreInitCallback {

            override fun onViewInitFinished(arg0: Boolean) {
                Log.d("lion", " onViewInitFinished is $arg0")
            }

            override fun onCoreInitFinished() {
                // do nothing
            }
        }
        QbSdk.initX5Environment(this, cb)
    }
}
