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


    @JvmStatic
    fun getString(strId: Int): String {
        return if (strId <= 0) {
            ""
        } else getApp().resources.getString(strId) ?: ""
    }

    @JvmStatic
    fun getStringArray(strArrayId: Int): Array<String>? {
        return if (strArrayId <= 0) {
            null
        } else getApp().resources.getStringArray(strArrayId)
    }

    @JvmStatic
    fun getString(strId: Int, vararg formatArgs: Any): String {
        return if (strId <= 0) {
            ""
        } else getApp().resources.getString(strId, *formatArgs) ?: ""
    }

    @JvmStatic
    fun getColor(colorId: Int): Int {
        return if (colorId <= 0) {
            -1
        } else ContextCompat.getColor(getApp(), colorId)
    }

    @JvmStatic
    fun getDrawable(drawableId: Int): Drawable? {
        return if (drawableId <= 0) {
            null
        } else ContextCompat.getDrawable(getApp(), drawableId)
    }

    @JvmStatic
    fun setTint(context: Context, DrawableRes: Int, tintColor: Int, imageView: ImageView) {
        val up = ContextCompat.getDrawable(context, DrawableRes)
        val drawableUp = DrawableCompat.wrap(up!!)
        DrawableCompat.setTint(drawableUp, ContextCompat.getColor(context, tintColor))
        imageView.setImageDrawable(drawableUp)
    }
}