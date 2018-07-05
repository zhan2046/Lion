package com.ruzhan.movie.detail

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item_movie_detail_title.view.*

/**
 * Created by ruzhan123 on 2018/7/5.
 */
class MovieDetailTitleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    fun bind(title: String, tag: String) {
        itemView.title_tv.text = title
        itemView.tag_tv.text = tag
    }
}