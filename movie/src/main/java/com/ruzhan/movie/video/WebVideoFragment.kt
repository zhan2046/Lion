package com.ruzhan.movie.video

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ruzhan.movie.R
import com.tencent.smtt.sdk.WebChromeClient
import com.tencent.smtt.sdk.WebView
import com.tencent.smtt.sdk.WebViewClient
import kotlinx.android.synthetic.main.lion_frag_web_video.*

class WebVideoFragment : Fragment() {

    companion object {

        private const val VIDEO_URL: String = "URL"
        private const val MAX_PROGRESS = 80

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
        web_view.loadUrl(url)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initData() {
        val webSettings = web_view.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true

        web_view.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                if (load_progress.visibility != View.VISIBLE && newProgress < MAX_PROGRESS) {
                    load_progress.visibility = View.VISIBLE

                } else if (newProgress > MAX_PROGRESS) {
                    load_progress.visibility = View.INVISIBLE
                }
            }
        }
        web_view.webViewClient = WebViewClient()
    }

    override fun onResume() {
        web_view.onResume()
        super.onResume()
    }

    override fun onPause() {
        web_view.onPause()
        super.onPause()
    }

    override fun onDestroyView() {
        web_view.destroy()
        super.onDestroyView()
    }
}