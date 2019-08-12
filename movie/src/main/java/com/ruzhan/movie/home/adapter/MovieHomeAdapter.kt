package com.ruzhan.movie.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ruzhan.lion.util.ResUtils
import com.ruzhan.movie.R
import com.ruzhan.movie.home.MovieListFragment2

class MovieHomeAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm) {

    private var titleList = ArrayList<String>()
    private val newListTab = ResUtils.getApp().getString(R.string.lion_tab_tag_new)
    private var newListTabPosition = 0

    fun setData(list: List<String>) {
        titleList.clear()
        titleList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Fragment {
        var dayTag = titleList[position]
        if (newListTab == dayTag) {
            newListTabPosition = position
        }
        if (position == 0) {
            dayTag = newListTab
            newListTabPosition = titleList.indexOf(newListTab)
        } else if (position == newListTabPosition) {
            dayTag = titleList[0]
        }
        return MovieListFragment2.newInstance(dayTag)
    }

    override fun getCount(): Int = titleList.size

    override fun getPageTitle(position: Int): CharSequence? {
        var title = titleList[position]
        if (position == 0) {
            title = newListTab
            newListTabPosition = titleList.indexOf(newListTab)
        } else if (position == newListTabPosition) {
            title = titleList[0]
        }
        return title
    }
}