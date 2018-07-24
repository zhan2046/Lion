package com.ruzhan.lion

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex

import com.blankj.utilcode.util.Utils

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

        Utils.init(this)
    }

    companion object {

        private var INSTANCE: App? = null

        fun get(): App {
            return this.INSTANCE!!
        }
    }
}
