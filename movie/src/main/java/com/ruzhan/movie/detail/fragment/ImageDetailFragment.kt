package com.ruzhan.movie.detail.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lion.font.FontHelper
import com.ruzhan.movie.R
import com.ruzhan.movie.detail.adapter.ImageDetailAdapter
import com.ruzhan.movie.model.ImageListModel
import kotlinx.android.synthetic.main.lion_frag_image_detail.*

class ImageDetailFragment : Fragment() {

    companion object {

        private const val IMAGE_LIST_MODEL: String = "IMAGE_LIST_MODEL"

        @JvmStatic
        fun newInstance(imageListModel: ImageListModel): ImageDetailFragment {
            val args = Bundle()
            args.putSerializable(IMAGE_LIST_MODEL, imageListModel)
            val frag = ImageDetailFragment()
            frag.arguments = args
            return frag
        }
    }

    private var imageListModel: ImageListModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageListModel = arguments?.getSerializable(IMAGE_LIST_MODEL) as ImageListModel
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.lion_frag_image_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initListener()
    }

    private fun initListener() {
        lion_image_view_page.addOnPageChangeListener(object : androidx.viewpager.widget.ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
                // do nothing
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                // do nothing
            }

            override fun onPageSelected(position: Int) {
                lion_image_current_tv.text = (position + 1).toString()
            }
        })
    }

    private fun initData() {
        val imageListModel = imageListModel
        if (imageListModel != null) {
            lion_image_current_tv.text = (imageListModel.position + 1).toString()
            lion_image_total_tv.text = imageListModel.imageList.size.toString()
            lion_image_title_tv.text = imageListModel.title
            lion_image_title_tv.typeface = FontHelper.get().getBoldTypeface()

            val imageDetailAdapter = ImageDetailAdapter(childFragmentManager, imageListModel.imageList)
            lion_image_view_page.adapter = imageDetailAdapter
            lion_image_view_page.currentItem = imageListModel.position
        }
    }
}