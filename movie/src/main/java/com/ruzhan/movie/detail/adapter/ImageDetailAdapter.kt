package com.ruzhan.movie.detail.adapter

import androidx.fragment.app.FragmentPagerAdapter
import com.ruzhan.movie.detail.fragment.ItemImageDetailFragment

class ImageDetailAdapter(fm: androidx.fragment.app.FragmentManager, imageList: ArrayList<String>) :
        FragmentPagerAdapter(fm) {

    private var imageList: List<String> = imageList

    override fun getItem(position: Int): androidx.fragment.app.Fragment {
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