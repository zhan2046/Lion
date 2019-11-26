package com.ruzhan.movie.detail.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lion.font.FontHelper
import kotlinx.android.synthetic.main.lion_item_movie_detail_video_title.view.*

class MovieDetailVideoTitleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    init {
        itemView.title_tv.typeface = FontHelper.get().boldFontTypeface
    }
}