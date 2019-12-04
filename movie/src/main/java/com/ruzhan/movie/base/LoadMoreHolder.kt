package com.ruzhan.movie.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lion.font.FontHelper
import com.ruzhan.movie.R
import kotlinx.android.synthetic.main.lion_item_load_more.view.*

class LoadMoreHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    init {
        itemView.load_tv.typeface = FontHelper.get().lightFontTypeface
    }

    fun bind(isShowLoadMore: Boolean) {
        itemView.load_progress_bar.visibility = if (isShowLoadMore) View.VISIBLE else View.GONE
        itemView.load_tv.text = if (isShowLoadMore) itemView.resources.getString(R.string.load_start)
        else itemView.resources.getString(R.string.load_end)
    }
}