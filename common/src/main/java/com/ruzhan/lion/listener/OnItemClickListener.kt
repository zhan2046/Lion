package com.ruzhan.lion.listener

import android.view.View

/**
 * Created by ruzhan123 on 2018/7/4.
 */
interface OnItemClickListener<in T> {
    
    fun onItemClick(position: Int, bean: T, itemView: View)
}