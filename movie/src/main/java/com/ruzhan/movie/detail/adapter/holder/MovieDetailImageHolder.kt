package com.ruzhan.movie.detail.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import com.lion.imageloader.glide.ImageLoader
import com.ruzhan.lion.listener.OnItemClickListener
import com.ruzhan.lion.model.Introduce
import com.ruzhan.lion.model.MovieDetail
import com.ruzhan.lion.util.ViewUtils
import com.ruzhan.movie.model.ImageListModel
import kotlinx.android.synthetic.main.lion_item_movie_detail_image.view.*

class MovieDetailImageHolder(itemView: View, private var movieDetail: MovieDetail,
                             listener: OnItemClickListener<ImageListModel>?) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

    private var imageListModel: ImageListModel = ImageListModel("", 0, "", ArrayList())
    private val imageUrlList = ArrayList<String>()
    private lateinit var url: String

    init {
        if (listener != null) {
            itemView.root_cv.setOnClickListener {
                resetImageListModel(url)
                listener.onItemClick(adapterPosition, imageListModel, it)
            }
        }
    }

    fun bind(bean: Introduce) {
        url = bean.image
        ImageLoader.get().load(itemView.image_iv, url,
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