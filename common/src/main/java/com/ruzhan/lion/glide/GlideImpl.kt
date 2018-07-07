package com.ruzhan.lion.glide

import android.widget.ImageView
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions



/**
 * Created by ruzhan123 on 2018/7/4.
 */
class GlideImpl : IImageLoader {

    override fun load(imageView: ImageView, url: String) {
        GlideApp.with(imageView.context)
                .load(url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
    }

    override fun load(imageView: ImageView, resId: Int) {
        GlideApp.with(imageView.context)
                .load(resId)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
    }

    override fun loadNoCrossFade(imageView: ImageView, url: String) {
        GlideApp.with(imageView.context)
                .load(url)
                .into(imageView)
    }

    override fun loadNoCrossFade(imageView: ImageView, resId: Int) {
        GlideApp.with(imageView.context)
                .load(resId)
                .into(imageView)
    }
}
