package com.ruzhan.movie.video

import android.app.Activity
import android.content.Intent
import android.graphics.PixelFormat
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.ruzhan.movie.R

class VideoActivity : AppCompatActivity() {

    companion object {

        private const val M3U8_URL = "M3U8_URL"

        @JvmStatic
        fun launch(activity: Activity, m3u8Url: String) {
            val intent = Intent(activity, VideoActivity::class.java)
            intent.putExtra(M3U8_URL, m3u8Url)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.setFormat(PixelFormat.TRANSLUCENT)
        setContentView(R.layout.lion_container)
        if (savedInstanceState == null) {
            val m3u8Url = intent.getStringExtra(M3U8_URL) ?: ""
            val videoFragment = VideoFragment.newInstance(m3u8Url)
            supportFragmentManager.beginTransaction()
                    .add(R.id.container, videoFragment, "VideoFragment")
                    .commit()
        }
    }
}