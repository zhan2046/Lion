package com.ruzhan.movie.home.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lion.font.FontHelper
import com.lion.imageloader.glide.ImageLoader
import com.ruzhan.lion.listener.OnItemClickListener
import com.ruzhan.lion.model.Movie
import com.ruzhan.lion.util.ViewUtils
import kotlinx.android.synthetic.main.lion_item_movie_list.view.*

class MovieListHolder(itemView: View, listener: OnItemClickListener<Movie>?) :
        RecyclerView.ViewHolder(itemView) {

    private lateinit var movie: Movie

    init {
        val lightFontTypeface = FontHelper.get().lightFontTypeface
        itemView.titleTv.typeface = FontHelper.get().boldFontTypeface
        itemView.contentTv.typeface = lightFontTypeface
        if (listener != null) {
            itemView.rootCardView.setOnClickListener {
                listener.onItemClick(adapterPosition, movie, itemView.picIv)
            }
        }
    }

    fun bind(bean: Movie) {
        movie = bean
        itemView.titleTv.text = movie.title
        itemView.contentTv.text = movie.desc
        ImageLoader.get().load(itemView.picIv, movie.image,
                ViewUtils.getPlaceholder(itemView.context, adapterPosition))
    }
}