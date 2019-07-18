package com.lion.imageloader.glide

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions

class GlideImpl : IImageLoader {

    private val requestOptions = RequestOptions().centerCrop()

    override fun load(imageView: ImageView, url: String) {
        Glide.with(imageView.context)
                .load(url)
                .apply(requestOptions)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
    }

    override fun load(imageView: ImageView, resId: Int) {
        Glide.with(imageView.context)
                .load(resId)
                .apply(requestOptions)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
    }

    override fun load(imageView: ImageView, url: String, placeholder: Drawable) {
        val requestOptions = RequestOptions().centerCrop().placeholder(placeholder)
        Glide.with(imageView.context)
                .load(url)
                .apply(requestOptions)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
    }

    override fun load(imageView: ImageView, resId: Int, placeholder: Drawable) {
        val requestOptions = RequestOptions().centerCrop().placeholder(placeholder)
        Glide.with(imageView.context)
                .load(resId)
                .apply(requestOptions)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
    }

    override fun loadNoCrossFade(imageView: ImageView, url: String) {
        Glide.with(imageView.context)
                .load(url)
                .apply(requestOptions)
                .into(imageView)
    }

    override fun loadNoCrossFade(imageView: ImageView, resId: Int) {
        Glide.with(imageView.context)
                .load(resId)
                .apply(requestOptions)
                .into(imageView)
    }

    override fun loadNoCrossFade(imageView: ImageView, url: String, placeholder: Drawable) {
        val requestOptions = RequestOptions().centerCrop().placeholder(placeholder)
        Glide.with(imageView.context)
                .load(url)
                .apply(requestOptions)
                .into(imageView)
    }

    override fun loadNoCrossFade(imageView: ImageView, resId: Int, placeholder: Drawable) {
        val requestOptions = RequestOptions().centerCrop().placeholder(placeholder)
        Glide.with(imageView.context)
                .load(resId)
                .apply(requestOptions)
                .into(imageView)
    }

    override fun loadCenterCrop(imageView: ImageView, url: String) {
        Glide.with(imageView.context)
                .load(url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
    }

    override fun loadCenterCrop(imageView: ImageView, url: String,
                                listener: RequestListener<Drawable>) {
        Glide.with(imageView.context)
                .load(url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .listener(listener)
                .into(imageView)
    }

    override fun loadCenterCrop(imageView: ImageView, resId: Int) {
        Glide.with(imageView.context)
                .load(resId)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
    }
}
