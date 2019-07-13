package com.ruzhan.movie.detail.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import com.ruzhan.movie.R
import com.ruzhan.movie.detail.fragment.ImageDetailFragment
import com.ruzhan.movie.model.ImageListModel

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
        setContentView(R.layout.lion_container)
        val imageListModel: ImageListModel = intent.getSerializableExtra(IMAGE_LIST_MODEL) as ImageListModel
        if (savedInstanceState == null) {
            val imageDetailFragment = ImageDetailFragment.newInstance(imageListModel)
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container, imageDetailFragment, "ImageDetailFragment")
                    .commit()
        }
    }
}