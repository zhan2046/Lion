package com.ruzhan.movie.detail.adapter.holder

import android.text.TextUtils
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.lion.font.FontHelper
import com.lion.imageloader.glide.ImageLoader
import com.ruzhan.lion.listener.OnItemClickListener
import com.ruzhan.lion.model.Video
import com.ruzhan.lion.util.ViewUtils
import com.ruzhan.movie.R
import kotlinx.android.synthetic.main.lion_item_movie_detail_video.view.*

class MovieDetailVideoHolder(itemView: View, listener: OnItemClickListener<Video>?) :
        RecyclerView.ViewHolder(itemView) {

    private lateinit var video: Video

    init {
        val lightFontTypeface = FontHelper.get().lightFontTypeface
        itemView.title_tv.typeface = lightFontTypeface
        if (listener != null) {
            itemView.root_cl.setOnClickListener { listener.onItemClick(adapterPosition, video, it) }
        }
    }

    fun bind(bean: Video) {
        video = bean
        itemView.title_tv.text = bean.title
        ImageLoader.get().load(itemView.image_iv, bean.image,
                ViewUtils.getPlaceholder(itemView.context, adapterPosition))

    }
}