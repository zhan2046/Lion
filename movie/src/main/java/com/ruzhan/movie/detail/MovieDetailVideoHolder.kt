package com.ruzhan.movie.detail

import android.support.v7.widget.RecyclerView
import android.view.View
import com.ruzhan.lion.glide.ImageLoader
import com.ruzhan.lion.listener.OnItemClickListener
import com.ruzhan.lion.model.Video
import com.ruzhan.lion.util.ViewUtils
import kotlinx.android.synthetic.main.item_movie_detail_video.view.*

/**
 * Created by ruzhan123 on 2018/7/5.
 */
class MovieDetailVideoHolder(itemView: View, listener: OnItemClickListener<Video>) : RecyclerView.ViewHolder(itemView) {

    private lateinit var video: Video

    init {
        itemView.root_cl.setOnClickListener { listener.onItemClick(adapterPosition, video, it) }
    }

    fun bind(bean: Video) {
        video = bean
        ImageLoader.get().load(itemView.image_iv, bean.image,
                ViewUtils.getPlaceholder(itemView.context, adapterPosition))
        itemView.title_tv.text = bean.title
    }
}