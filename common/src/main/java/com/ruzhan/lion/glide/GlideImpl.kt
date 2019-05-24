package com.ruzhan.lion.glide

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener

class GlideImpl : IImageLoader {

    override fun load(imageView: ImageView, url: String) {
        GlideApp.with(imageView.context)
                .load(url)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
    }

    override fun load(imageView: ImageView, resId: Int) {
        GlideApp.with(imageView.context)
                .load(resId)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
    }

    override fun load(imageView: ImageView, url: String, placeholder: Drawable) {
        GlideApp.with(imageView.context)
                .load(url)
                .placeholder(placeholder)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
    }

    override fun load(imageView: ImageView, resId: Int, placeholder: Drawable) {
        GlideApp.with(imageView.context)
                .load(resId)
                .placeholder(placeholder)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
    }

    override fun loadNoCrossFade(imageView: ImageView, url: String) {
        GlideApp.with(imageView.context)
                .load(url)
                .centerCrop()
                .into(imageView)
    }

    override fun loadNoCrossFade(imageView: ImageView, resId: Int) {
        GlideApp.with(imageView.context)
                .load(resId)
                .centerCrop()
                .into(imageView)
    }

    override fun loadNoCrossFade(imageView: ImageView, url: String, placeholder: Drawable) {
        GlideApp.with(imageView.context)
                .load(url)
                .placeholder(placeholder)
                .centerCrop()
                .into(imageView)
    }

    override fun loadNoCrossFade(imageView: ImageView, resId: Int, placeholder: Drawable) {
        GlideApp.with(imageView.context)
                .load(resId)
                .placeholder(placeholder)
                .centerCrop()
                .into(imageView)
    }

    override fun loadCenterCrop(imageView: ImageView, url: String) {
        GlideApp.with(imageView.context)
                .load(url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
    }

    override fun loadCenterCrop(imageView: ImageView, url: String,
                                           listener: RequestListener<Drawable>) {
        GlideApp.with(imageView.context)
                .load(url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .listener(listener)
                .into(imageView)
    }

    override fun loadCenterCrop(imageView: ImageView, resId: Int) {
        GlideApp.with(imageView.context)
                .load(resId)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
    }
}
