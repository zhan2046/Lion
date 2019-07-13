package com.ruzhan.movie.home.adapter.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.lion.imageloader.glide.ImageLoader
import com.ruzhan.lion.helper.FontHelper
import com.ruzhan.lion.listener.OnItemClickListener
import com.ruzhan.lion.model.Movie
import com.ruzhan.lion.util.ViewUtils
import kotlinx.android.synthetic.main.lion_item_movie_list.view.*

class MovieListHolder(itemView: View, listener: OnItemClickListener<Movie>?) : RecyclerView.ViewHolder(itemView) {

    private lateinit var movie: Movie

    init {
        itemView.tag_tv.typeface = FontHelper.get().getLightTypeface()
        itemView.title_tv.typeface = FontHelper.get().getBoldTypeface()
        itemView.desc_tv.typeface = FontHelper.get().getLightTypeface()
        if (listener != null) {
            itemView.root_cl.setOnClickListener {
                listener.onItemClick(adapterPosition, movie, itemView.image_iv)
            }
        }
    }

    fun bind(bean: Movie) {
        movie = bean
        itemView.title_tv.text = movie.title
        itemView.tag_tv.text = movie.tag
        itemView.desc_tv.text = movie.desc
        ImageLoader.get().load(itemView.image_iv, movie.image,
                ViewUtils.getPlaceholder(itemView.context, adapterPosition))
    }
}