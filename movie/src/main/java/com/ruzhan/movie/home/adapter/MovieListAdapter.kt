package com.ruzhan.movie.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ruzhan.movie.listener.OnItemClickListener
import com.ruzhan.movie.base.LoadMoreHolder
import com.ruzhan.movie.R
import com.ruzhan.movie.db.entity.MovieEntity
import com.ruzhan.movie.home.adapter.holder.MovieEmptyHolder
import com.ruzhan.movie.home.adapter.holder.MovieListHolder


class MovieListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val LOAD_MORE: String = "LOAD_MORE"

        const val TYPE_NORMAL: Int = 1000
        const val TYPE_LOAD_MORE: Int = 1001
    }

    private var dataList = ArrayList<Any>()
    private var isLoadMore: Boolean = false

    var onItemClickListener: OnItemClickListener<MovieEntity>? = null

    fun setData(movieList: List<MovieEntity>?) {
        if (movieList != null && movieList.isNotEmpty()) {
            dataList.clear()
            dataList.addAll(movieList)
            dataList.add(LOAD_MORE)
            notifyDataSetChanged()
        }
    }

    override fun getItemViewType(position: Int): Int {
        var viewType = 0
        val obj = dataList[position]

        if (obj is String) {
            viewType = TYPE_LOAD_MORE
        } else if (obj is MovieEntity) {
            viewType = TYPE_NORMAL
        }
        return viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_NORMAL -> MovieListHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.lion_item_movie_list, parent, false),
                    onItemClickListener)

            TYPE_LOAD_MORE -> LoadMoreHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.lion_item_load_more, parent, false))

            else -> MovieEmptyHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.lion_item_empty, parent, false))
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_NORMAL -> (holder as MovieListHolder).bind(dataList[position] as MovieEntity)
            TYPE_LOAD_MORE -> (holder as LoadMoreHolder).bind(isLoadMore)
        }
    }

}