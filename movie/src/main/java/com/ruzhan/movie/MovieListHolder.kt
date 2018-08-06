package com.ruzhan.movie

import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.View
import com.ruzhan.lion.glide.ImageLoader
import com.ruzhan.lion.listener.OnItemClickListener
import com.ruzhan.lion.model.Movie
import com.ruzhan.lion.util.FontUtils
import com.ruzhan.lion.util.ViewUtils
import kotlinx.android.synthetic.main.item_movie_list.view.*

/**
 * Created by ruzhan123 on 2018/7/4.
 */
class MovieListHolder(itemView: View, listener: OnItemClickListener<Movie>) : RecyclerView.ViewHolder(itemView) {

    private lateinit var movie: Movie
    private var itemClickListener: OnItemClickListener<Movie> = listener

    init {
        val assetManager = itemView.context.assets
        itemView.tag_tv.typeface = Typeface.createFromAsset(assetManager, FontUtils.TEXT_LIGHT)
        itemView.title_tv.typeface = Typeface.createFromAsset(assetManager, FontUtils.TEXT_BOLD)
        itemView.desc_tv.typeface = Typeface.createFromAsset(assetManager, FontUtils.TEXT_LIGHT)

        itemView.root_cl.setOnClickListener { itemClickListener.onItemClick(adapterPosition, movie, itemView.image_iv) }
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