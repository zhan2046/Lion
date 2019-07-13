package com.ruzhan.lion.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import com.lion.font.FontHelper
import com.ruzhan.common.R
import kotlinx.android.synthetic.main.lion_item_load_more.view.*

class LoadMoreHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    init {
        itemView.load_tv.typeface = FontHelper.get().getLightTypeface()
    }

    fun bind(isShowLoadMore: Boolean) {
       itemView.load_progress_bar.visibility = if (isShowLoadMore) View.VISIBLE else View.GONE
       itemView.load_tv.text = if (isShowLoadMore) itemView.resources.getString(R.string.load_start)
       else itemView.resources.getString(R.string.load_end)
    }
}