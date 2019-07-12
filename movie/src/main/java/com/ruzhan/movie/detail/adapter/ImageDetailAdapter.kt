package com.ruzhan.movie.detail.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.ruzhan.movie.detail.fragment.ItemImageDetailFragment

class ImageDetailAdapter(fm: FragmentManager, imageList: ArrayList<String>) :
        FragmentPagerAdapter(fm) {

    private var imageList: List<String> = imageList

    override fun getItem(position: Int): Fragment {
        val imageUrl = imageList[position]
        return ItemImageDetailFragment.newInstance(imageUrl)
    }

    override fun getCount(): Int {
        return imageList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return imageList[position]
    }
}