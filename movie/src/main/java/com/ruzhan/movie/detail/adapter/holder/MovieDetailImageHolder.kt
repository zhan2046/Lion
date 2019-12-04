package com.ruzhan.movie.detail.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lion.imageloader.glide.ImageLoader
import com.ruzhan.movie.db.entity.MovieDetailEntity
import com.ruzhan.movie.listener.OnItemClickListener
import com.ruzhan.movie.model.Introduce
import com.ruzhan.movie.utils.ViewUtils
import com.ruzhan.movie.model.ImageListModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.lion_item_movie_detail_image.*

class MovieDetailImageHolder(itemView: View, private var movieDetail: MovieDetailEntity,
                             listener: OnItemClickListener<ImageListModel>?) :
        RecyclerView.ViewHolder(itemView), LayoutContainer {

    override val containerView: View?
        get() = itemView

    private var imageListModel: ImageListModel = ImageListModel("", 0, "", ArrayList())
    private val imageUrlList = ArrayList<String>()
    private lateinit var url: String

    init {
        if (listener != null) {
            rootCardView.setOnClickListener {
                resetImageListModel(url)
                listener.onItemClick(adapterPosition, imageListModel, it)
            }
        }
    }

    fun bind(bean: Introduce) {
        url = bean.image
        ImageLoader.get().load(picIv, url,
                ViewUtils.getPlaceholder(itemView.context, adapterPosition))
    }

    private fun resetImageListModel(url: String) {
        imageUrlList.clear()
        for (item in movieDetail.introduces) {
            if (Introduce.IMAGE == item.type) {
                imageUrlList.add(item.image)
            }
        }
        var position = 0
        for (index in imageUrlList.indices) {
            if (url == imageUrlList[index]) {
                position = index
                break
            }
        }
        imageListModel.title = movieDetail.title
        imageListModel.url = url
        imageListModel.position = position
        imageListModel.imageList = imageUrlList
    }
}