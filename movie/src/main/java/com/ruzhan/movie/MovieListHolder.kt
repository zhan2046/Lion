package com.ruzhan.movie

import android.support.v7.widget.RecyclerView
import android.view.View
import com.ruzhan.lion.listener.OnItemClickListener
import com.ruzhan.lion.model.Movie
import kotlinx.android.synthetic.main.item_movie_list.view.*

/**
 * Created by ruzhan123 on 2018/7/4.
 */
class MovieListHolder(itemView: View, listener: OnItemClickListener<Movie>) : RecyclerView.ViewHolder(itemView) {

    private lateinit var movie: Movie
    private var itemClickListener: OnItemClickListener<Movie> = listener

    init {
        itemView.root_cl.setOnClickListener { itemClickListener.onItemClick(adapterPosition, movie, itemView) }
    }

    fun bind(bean: Movie) {
        movie = bean
        itemView.title_tv.text = movie.title
    }
}