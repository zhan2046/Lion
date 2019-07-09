package com.ruzhan.lion.util

import android.app.Application

object ResUtils {

    private lateinit var application: Application

    @JvmStatic
    fun init(application: Application) {
        this.application = application
    }

    @JvmStatic
    fun getApp(): Application = application
}