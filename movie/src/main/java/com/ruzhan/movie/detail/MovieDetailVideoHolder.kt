package com.ruzhan.movie.detail

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.View
import com.ruzhan.lion.glide.ImageLoader
import com.ruzhan.lion.helper.FontHelper
import com.ruzhan.lion.listener.OnItemClickListener
import com.ruzhan.lion.model.Video
import com.ruzhan.lion.util.ViewUtils
import com.ruzhan.movie.R
import kotlinx.android.synthetic.main.item_movie_detail_video.view.*

class MovieDetailVideoHolder(itemView: View, listener: OnItemClickListener<Video>) : RecyclerView.ViewHolder(itemView) {

    private lateinit var video: Video

    init {
        itemView.play_count_tv.typeface = FontHelper.get().getLightTypeface()
        itemView.title_tv.typeface = FontHelper.get().getLightTypeface()

        itemView.root_cl.setOnClickListener { listener.onItemClick(adapterPosition, video, it) }
    }

    fun bind(bean: Video) {
        video = bean
        itemView.title_tv.text = bean.title
        itemView.play_count_tv.background = if (TextUtils.isEmpty(bean.playNumberDesc)) {
            null
        } else {
            ContextCompat.getDrawable(itemView.context, R.drawable.shape_blue_radius_bg)
        }
        itemView.play_count_tv.text = bean.playNumberDesc
        ImageLoader.get().load(itemView.image_iv, bean.image,
                ViewUtils.getPlaceholder(itemView.context, adapterPosition))

    }
}