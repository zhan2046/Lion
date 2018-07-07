package com.ruzhan.lion.glide

import android.widget.ImageView

/**
 * Created by ruzhan123 on 2018/7/4.
 */
interface IImageLoader {

    fun load(imageView: ImageView, url: String)

    fun load(imageView: ImageView, resId: Int)

    fun loadNoCrossFade(imageView: ImageView, url: String)

    fun loadNoCrossFade(imageView: ImageView, resId: Int)
}