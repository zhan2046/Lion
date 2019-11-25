package com.ruzhan.movie.detail.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lion.font.FontHelper
import kotlinx.android.synthetic.main.lion_item_movie_detail_title.view.*

class MovieDetailTitleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    init {
        itemView.tag_tv.typeface = FontHelper.get().getLightTypeface()
        itemView.title_tv.typeface = FontHelper.get().getBoldTypeface()
    }

    fun bind(title: String, tag: String) {
        itemView.title_tv.text = title
        itemView.tag_tv.text = tag
    }
}