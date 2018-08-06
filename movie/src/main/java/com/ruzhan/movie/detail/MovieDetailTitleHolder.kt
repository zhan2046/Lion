package com.ruzhan.movie.detail

import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.View
import com.ruzhan.lion.util.FontUtils
import kotlinx.android.synthetic.main.item_movie_detail_title.view.*

/**
 * Created by ruzhan123 on 2018/7/5.
 */
class MovieDetailTitleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    init {
        val assetManager = itemView.context.assets
        itemView.tag_tv.typeface = Typeface.createFromAsset(assetManager, FontUtils.TEXT_LIGHT)
        itemView.title_tv.typeface = Typeface.createFromAsset(assetManager, FontUtils.TEXT_BOLD)
    }

    fun bind(title: String, tag: String) {
        itemView.title_tv.text = title
        itemView.tag_tv.text = tag
    }
}