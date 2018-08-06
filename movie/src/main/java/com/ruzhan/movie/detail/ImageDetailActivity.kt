package com.ruzhan.movie.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import com.ruzhan.lion.helper.FontHelper
import com.ruzhan.movie.ImageListModel
import com.ruzhan.movie.R
import kotlinx.android.synthetic.main.lion_activity_image_detail.*

/**
 * Created by ruzhan123 on 2018/7/25.
 */
class ImageDetailActivity : AppCompatActivity() {

    companion object {

        private const val IMAGE_LIST_MODEL: String = "IMAGE_LIST_MODEL"

        @JvmStatic
        fun launch(activity: Activity, imageListModel: ImageListModel) {
            val intent = Intent(activity, ImageDetailActivity::class.java)
            intent.putExtra(IMAGE_LIST_MODEL, imageListModel)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.lion_activity_image_detail)

        val imageListModel: ImageListModel = intent.getSerializableExtra(IMAGE_LIST_MODEL) as ImageListModel

        lion_image_current_tv.text = (imageListModel.position + 1).toString()
        lion_image_total_tv.text = imageListModel.imageList.size.toString()
        lion_image_title_tv.text = imageListModel.title

        lion_image_title_tv.typeface = FontHelper.get().getBoldTypeface()

        val imageDetailAdapter = ImageDetailAdapter(supportFragmentManager, imageListModel.imageList)
        lion_image_view_page.adapter = imageDetailAdapter

        lion_image_view_page.currentItem = imageListModel.position

        lion_image_view_page.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                lion_image_current_tv.text = (position + 1).toString()
            }
        })
    }

    class ImageDetailAdapter(fm: FragmentManager, imageList: ArrayList<String>) : FragmentPagerAdapter(fm) {

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
}