package com.ruzhan.movie.video

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.fragment.app.Fragment
import com.ruzhan.movie.R
import com.tencent.smtt.sdk.WebChromeClient
import com.tencent.smtt.sdk.WebView
import com.tencent.smtt.sdk.WebViewClient
import kotlinx.android.synthetic.main.lion_frag_web_video.*

class WebVideoFragment : Fragment() {

    companion object {

        private const val VIDEO_URL: String = "URL"
        private const val MAX_PROGRESS = 80

        private const val DEFAULT_VIDEO_SCREEN = "DefaultVideoScreen"
        private const val SET_VIDEO_PARAMS = "setVideoParams"
        private const val X5_VIDEO_SCREEN_FULL = 2

        @JvmStatic
        fun newInstance(url: String): WebVideoFragment {
            val args = Bundle()
            args.putString(VIDEO_URL, url)
            val frag = WebVideoFragment()
            frag.arguments = args
            return frag
        }
    }

    private var url = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        url = arguments?.getString(VIDEO_URL) ?: ""
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.lion_frag_web_video, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        x5WebView.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                x5WebView.viewTreeObserver.removeOnGlobalLayoutListener(this)
                x5WebView.loadUrl(url)
            }
        })
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initData() {
        val webSettings = x5WebView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true

        x5WebView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                if (load_progress.visibility != View.VISIBLE && newProgress < MAX_PROGRESS) {
                    load_progress.visibility = View.VISIBLE

                } else if (newProgress > MAX_PROGRESS) {
                    load_progress.visibility = View.INVISIBLE
                }
            }
        }
        x5WebView.webViewClient = WebViewClient()
        val x5Bundle = Bundle()
        x5Bundle.putInt(DEFAULT_VIDEO_SCREEN, X5_VIDEO_SCREEN_FULL)
        x5WebView.x5WebViewExtension.invokeMiscMethod(SET_VIDEO_PARAMS, x5Bundle)
    }

    override fun onResume() {
        x5WebView.onResume()
        super.onResume()
    }

    override fun onPause() {
        x5WebView.onPause()
        super.onPause()
    }

    override fun onDestroyView() {
        x5WebView.destroy()
        super.onDestroyView()
    }
}