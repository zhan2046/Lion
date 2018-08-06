package com.ruzhan.lion.ui

import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.View
import com.ruzhan.common.R
import com.ruzhan.lion.util.FontUtils
import kotlinx.android.synthetic.main.item_load_more.view.*

/**
 * Created by ruzhan123 on 2018/7/5.
 */
class LoadMoreHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    init {
        val assetManager = itemView.context.assets
        itemView.load_tv.typeface = Typeface.createFromAsset(assetManager, FontUtils.TEXT_LIGHT)
    }

    fun bind(isShowLoadMore: Boolean) {
       itemView.load_progress_bar.visibility = if (isShowLoadMore) View.VISIBLE else View.GONE
       itemView.load_tv.text = if (isShowLoadMore) itemView.resources.getString(R.string.load_start)
       else itemView.resources.getString(R.string.load_end)
    }
}