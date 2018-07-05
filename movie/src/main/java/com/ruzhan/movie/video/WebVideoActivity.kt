package com.ruzhan.movie.video

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.ruzhan.movie.R
import kotlinx.android.synthetic.main.activity_web_video.*

/**
 * Created by ruzhan123 on 2018/7/5.
 */
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

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_web_video)

        val webSettings = web_view.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true

        web_view.webChromeClient = WebChromeClient()
        web_view.webViewClient = WebViewClient()

        val url = intent.getStringExtra(VIDEO_URL)
        web_view.loadUrl(url)
    }
}