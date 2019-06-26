package com.ruzhan.movie

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ruzhan.lion.listener.OnItemClickListener
import com.ruzhan.lion.model.Movie
import com.ruzhan.lion.model.RequestStatus
import com.ruzhan.lion.ui.LoadMoreHolder


class MovieListAdapter(listener: OnItemClickListener<Movie>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val LOAD_MORE: String = "LOAD_MORE"

        const val TYPE_NORMAL: Int = 1000
        const val TYPE_LOAD_MORE: Int = 1001
    }

    private var dataList = ArrayList<Any>()
    private var itemClickListener: OnItemClickListener<Movie> = listener
    private var isLoadMore: Boolean = false

    fun setRefreshData(movieList: List<Movie>) {
        if (movieList.isNotEmpty()) {
            dataList.clear()
            dataList.addAll(movieList)
            dataList.add(LOAD_MORE)
            isLoadMore = movieList.size >= RequestStatus.PAGE_SIZE
            notifyDataSetChanged()
        }
    }

    fun setLoadMoreData(movieList: List<Movie>) {
        if (movieList.isNotEmpty()) {
            dataList.remove(LOAD_MORE)

            dataList.addAll(movieList)
            dataList.add(LOAD_MORE)
            isLoadMore = movieList.size >= RequestStatus.PAGE_SIZE
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        lateinit var viewHolder: RecyclerView.ViewHolder
        when (viewType) {
            TYPE_NORMAL -> viewHolder = MovieListHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_movie_list, parent, false), itemClickListener)

            TYPE_LOAD_MORE -> viewHolder = LoadMoreHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_load_more, parent, false))
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_NORMAL -> (holder as MovieListHolder).bind(dataList[position] as Movie)
            TYPE_LOAD_MORE -> (holder as LoadMoreHolder).bind(isLoadMore)
        }
    }

}