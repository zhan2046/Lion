package com.ruzhan.movie.utils

import android.app.Application
import com.tencent.smtt.sdk.QbSdk

object X5Helper {

    @JvmStatic
    fun init(application: Application) {
        QbSdk.initX5Environment(application, null)
    }
}