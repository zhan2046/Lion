package com.ruzhan.lion

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex

import com.blankj.utilcode.util.Utils
import com.crashlytics.android.Crashlytics
import com.ruzhan.common.BuildConfig
import com.ruzhan.lion.util.LionUtils
import io.fabric.sdk.android.Fabric

/**
 * Created by ruzhan123 on 2018/7/4.
 */
class App : Application() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        if (BuildConfig.BUILD_TYPE.equals(LionUtils.RELEASE)) {
            Fabric.with(this, Crashlytics())
        }
        Utils.init(this)
    }

    companion object {

        private lateinit var INSTANCE: Application

        fun get(): Application {
            return this.INSTANCE
        }

        fun setApp(application: Application) {
            INSTANCE = application
        }
    }
}
