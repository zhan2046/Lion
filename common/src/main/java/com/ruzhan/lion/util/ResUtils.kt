package com.ruzhan.lion.util

import android.app.Application
import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat

object ResUtils {

    private lateinit var application: Application

    @JvmStatic
    fun init(application: Application) {
        this.application = application
    }

    @JvmStatic
    fun getApp(): Application = application
}