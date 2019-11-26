package com.ruzhan.movie.detail.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lion.font.FontHelper
import com.ruzhan.lion.model.Introduce
import kotlinx.android.synthetic.main.lion_item_movie_detail_text.view.*

class MovieDetailTextHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    init {
        itemView.text_tv.typeface = FontHelper.get().lightFontTypeface
    }

    fun bind(bean: Introduce) {
        itemView.text_tv.text = bean.text
    }
}