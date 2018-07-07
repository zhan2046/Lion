package com.ruzhan.movie.detail

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ruzhan.lion.listener.OnItemClickListener
import com.ruzhan.lion.model.Introduce
import com.ruzhan.lion.model.MovieDetail
import com.ruzhan.lion.model.Video
import com.ruzhan.movie.R
import java.util.*

/**
 * Created by ruzhan123 on 2018/7/5.
 */
class MovieDetailAdapter(listener: OnItemClickListener<Video>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_HEADER: Int = 1000
        const val TYPE_TITLE: Int = 1001
        const val TYPE_TEXT: Int = 1002
        const val TYPE_IMAGE: Int = 1003
        const val TYPE_VIDEO_TITLE: Int = 1005
        const val TYPE_VIDEO: Int = 1006

        const val HEADER: String = "HEADER"
        const val VIDEO_TITLE: String = "VIDEO_TITLE"
    }

    private var dataList: ArrayList<Any> = ArrayList()
    private lateinit var movieDetail: MovieDetail
    private var itemClickListener: OnItemClickListener<Video> = listener
    private lateinit var movieDetailHeaderHolder: MovieDetailHeaderHolder

    fun setData(movieDetail: MovieDetail) {
        this.movieDetail = movieDetail
        dataList.clear()
        dataList.add(HEADER)
        dataList.add(movieDetail.title)
        dataList.addAll(movieDetail.introduces)
        dataList.add(VIDEO_TITLE)
        dataList.addAll(movieDetail.videos)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        val obj = dataList[position]
        var viewType = 0
        if (obj is String) {
            viewType = when {
                HEADER == obj -> TYPE_HEADER
                VIDEO_TITLE == obj -> TYPE_VIDEO_TITLE
                else -> TYPE_TITLE
            }

        } else if (obj is Introduce) {
            if (Introduce.TEXT == obj.type) {
                viewType = TYPE_TEXT

            } else if (Introduce.IMAGE == obj.type) {
                viewType = TYPE_IMAGE
            }
        } else if (obj is Video) {
            viewType = TYPE_VIDEO
        }
        return viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        lateinit var viewHolder: RecyclerView.ViewHolder
        when (viewType) {
            TYPE_HEADER -> {
                viewHolder = MovieDetailHeaderHolder(LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_movie_detail_header, parent, false))
                movieDetailHeaderHolder = viewHolder
            }
            TYPE_TITLE -> viewHolder = MovieDetailTitleHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_movie_detail_title, parent, false))
            TYPE_TEXT -> viewHolder = MovieDetailTextHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_movie_detail_text, parent, false))
            TYPE_IMAGE -> viewHolder = MovieDetailImageHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_movie_detail_image, parent, false))
            TYPE_VIDEO -> viewHolder = MovieDetailVideoHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_movie_detail_video, parent, false), itemClickListener)
            TYPE_VIDEO_TITLE -> viewHolder = MovieDetailVideoTitleHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_movie_detail_video_title, parent, false))
        }
        return viewHolder
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType = getItemViewType(position)
        when (viewType) {
            TYPE_TITLE -> (holder as MovieDetailTitleHolder).bind(movieDetail.title, movieDetail.tag)
            TYPE_TEXT -> (holder as MovieDetailTextHolder).bind(dataList[position] as Introduce)
            TYPE_IMAGE -> (holder as MovieDetailImageHolder).bind(dataList[position] as Introduce)
            TYPE_VIDEO -> (holder as MovieDetailVideoHolder).bind(dataList[position] as Video)
        }
    }

    fun getMovieDetailHeaderHolder(): MovieDetailHeaderHolder {
        return movieDetailHeaderHolder
    }
}