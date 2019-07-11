package com.ruzhan.movie.video

import android.app.Activity
import android.content.Intent
import android.graphics.PixelFormat
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import com.ruzhan.movie.R

class WebVideoActivity : AppCompatActivity() {

    companion object {

        private const val VIDEO_URL: String = "URL"

        @JvmStatic
        fun launch(activity: Activity, url: String) {
            val intent = Intent(activity, WebVideoActivity::class.java)
            intent.putExtra(VIDEO_URL, url)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.setFormat(PixelFormat.TRANSLUCENT)
        setContentView(R.layout.container)

        val url = intent.getStringExtra(VIDEO_URL)
        if (savedInstanceState == null) {
            val webVideoFragment = WebVideoFragment.newInstance(url)
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container, webVideoFragment, "WebVideoFragment")
                    .commit()
        }
    }
}