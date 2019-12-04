package com.ruzhan.movie.listener

import android.view.View

interface OnItemClickListener<in T> {

    fun onItemClick(position: Int, bean: T, itemView: View)
}