package com.ruzhan.movie.home.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ruzhan.lion.listener.OnItemClickListener
import com.ruzhan.lion.model.Movie
import com.ruzhan.lion.ui.LoadMoreHolder
import com.ruzhan.movie.R
import com.ruzhan.movie.home.adapter.holder.MovieListHolder


class MovieListAdapter : androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>() {

    companion object {
        const val LOAD_MORE: String = "LOAD_MORE"

        const val TYPE_NORMAL: Int = 1000
        const val TYPE_LOAD_MORE: Int = 1001

        private const val PAGE_SIZE = 60
    }

    private var dataList = ArrayList<Any>()
    private var isLoadMore: Boolean = false

    var onItemClickListener: OnItemClickListener<Movie>? = null

    fun setRefreshData(movieList: List<Movie>) {
        if (movieList.isNotEmpty()) {
            dataList.clear()
            dataList.addAll(movieList)
            dataList.add(LOAD_MORE)
            isLoadMore = movieList.size >= PAGE_SIZE
            notifyDataSetChanged()
        }
    }

    fun setLoadMoreData(movieList: List<Movie>) {
        if (movieList.isNotEmpty()) {
            dataList.remove(LOAD_MORE)

            dataList.addAll(movieList)
            dataList.add(LOAD_MORE)
            isLoadMore = movieList.size >= PAGE_SIZE
            notifyDataSetChanged()
        }
    }

    override fun getItemViewType(position: Int): Int {
        var viewType = 0
        val obj = dataList[position]

        if (obj is String) {
            viewType = TYPE_LOAD_MORE
        } else if (obj is Movie) {
            viewType = TYPE_NORMAL
        }
        return viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder {
        lateinit var viewHolder: androidx.recyclerview.widget.RecyclerView.ViewHolder
        when (viewType) {
            TYPE_NORMAL -> viewHolder = MovieListHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.lion_item_movie_list, parent, false), onItemClickListener)

            TYPE_LOAD_MORE -> viewHolder = LoadMoreHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.lion_item_load_more, parent, false))
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_NORMAL -> (holder as MovieListHolder).bind(dataList[position] as Movie)
            TYPE_LOAD_MORE -> (holder as LoadMoreHolder).bind(isLoadMore)
        }
    }

}