package com.ruzhan.movie.detail

import android.support.v7.widget.RecyclerView
import android.view.View
import com.ruzhan.lion.glide.ImageLoader
import com.ruzhan.lion.model.Introduce
import com.ruzhan.lion.util.ViewUtils
import kotlinx.android.synthetic.main.item_movie_detail_image.view.*

/**
 * Created by ruzhan123 on 2018/7/5.
 */
class MovieDetailImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    fun bind(bean: Introduce) {
        ImageLoader.get().load(itemView.image_iv, bean.image,
                ViewUtils.getPlaceholder(itemView.context, adapterPosition))
    }
}