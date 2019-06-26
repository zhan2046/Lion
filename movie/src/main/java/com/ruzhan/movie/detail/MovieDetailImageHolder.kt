package com.ruzhan.movie.detail

import android.support.v7.widget.RecyclerView
import android.view.View
import com.ruzhan.lion.glide.ImageLoader
import com.ruzhan.lion.listener.OnItemClickListener
import com.ruzhan.lion.model.Introduce
import com.ruzhan.lion.model.MovieDetail
import com.ruzhan.lion.util.ViewUtils
import com.ruzhan.movie.ImageListModel
import kotlinx.android.synthetic.main.item_movie_detail_image.view.*

class MovieDetailImageHolder(itemView: View, movieDetail: MovieDetail,
                             listener: OnItemClickListener<ImageListModel>) : RecyclerView.ViewHolder(itemView) {

    private var imageListModel: ImageListModel = ImageListModel("", 0, "", ArrayList())
    private val imageUrlList = ArrayList<String>()
    private var movieDetail: MovieDetail = movieDetail
    private lateinit var url: String

    init {
        itemView.root_cv.setOnClickListener {
            resetImageListModel(url)
            listener.onItemClick(adapterPosition, imageListModel, it)
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