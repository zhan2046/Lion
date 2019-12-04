package com.ruzhan.movie.home.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lion.font.FontHelper
import com.lion.imageloader.glide.ImageLoader
import com.ruzhan.lion.listener.OnItemClickListener
import com.ruzhan.lion.util.ViewUtils
import com.ruzhan.movie.db.entity.MovieEntity
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.lion_item_movie_list.*

class MovieListHolder(itemView: View, listener: OnItemClickListener<MovieEntity>?) :
        RecyclerView.ViewHolder(itemView), LayoutContainer {

    private lateinit var movie: MovieEntity

    override val containerView: View?
        get() = itemView

    init {
        val lightFontTypeface = FontHelper.get().lightFontTypeface
        titleTv.typeface = FontHelper.get().boldFontTypeface
        contentTv.typeface = lightFontTypeface
        if (listener != null) {
            rootCardView.setOnClickListener {
                listener.onItemClick(adapterPosition, movie, picIv)
            }
        }
    }

    fun bind(bean: MovieEntity) {
        movie = bean
        titleTv.text = movie.title
        contentTv.text = movie.desc
        ImageLoader.get().load(picIv, movie.image,
                ViewUtils.getPlaceholder(itemView.context, adapterPosition))
    }
}