package com.ruzhan.movie.detail

import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.View
import com.ruzhan.lion.model.Introduce
import com.ruzhan.lion.util.FontUtils
import kotlinx.android.synthetic.main.item_movie_detail_text.view.*

/**
 * Created by ruzhan123 on 2018/7/5.
 */
class MovieDetailTextHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    init {
        val assetManager = itemView.context.assets
        itemView.text_tv.typeface = Typeface.createFromAsset(assetManager, FontUtils.TEXT_LIGHT)
    }

    fun bind(bean: Introduce) {
        itemView.text_tv.text = bean.text
    }
}