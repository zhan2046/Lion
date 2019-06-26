package com.ruzhan.movie.detail

import android.support.v7.widget.RecyclerView
import android.view.View
import com.ruzhan.lion.helper.FontHelper
import com.ruzhan.lion.model.Introduce
import kotlinx.android.synthetic.main.item_movie_detail_text.view.*

class MovieDetailTextHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    init {
        itemView.text_tv.typeface = FontHelper.get().getLightTypeface()
    }

    fun bind(bean: Introduce) {
        itemView.text_tv.text = bean.text
    }
}