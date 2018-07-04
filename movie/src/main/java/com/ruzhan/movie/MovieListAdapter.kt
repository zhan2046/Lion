package com.ruzhan.movie

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ruzhan.lion.listener.OnItemClickListener
import com.ruzhan.lion.model.Movie


/**
 * Created by ruzhan123 on 2018/7/4.
 */
class MovieListAdapter(listener: OnItemClickListener<Movie>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var dataList = ArrayList<Movie>()
    private var itemClickListener: OnItemClickListener<Movie> = listener

    fun setData(movieList: List<Movie>) {
        dataList.clear()
        dataList.addAll(movieList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val movieListHolder = MovieListHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_movie_list, parent, false), itemClickListener)
        return movieListHolder
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MovieListHolder).bind(dataList[position])
    }

}