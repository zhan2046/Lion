package com.ruzhan.movie.video

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.ruzhan.movie.R
import kotlinx.android.synthetic.main.lion_frag_web_video.*

@Suppress("DEPRECATION")
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initData() {
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                if (progressBar.visibility != View.VISIBLE && newProgress < MAX_PROGRESS) {
                    progressBar.visibility = View.VISIBLE

                } else if (newProgress > MAX_PROGRESS) {
                    progressBar.visibility = View.INVISIBLE
                }
            }
        }
        webView.webViewClient = WebViewClient()
        webView.loadUrl(url)
    }

    override fun onResume() {
        webView.onResume()
        super.onResume()
    }

    override fun onPause() {
        webView.onPause()
        super.onPause()
    }

    override fun onDestroyView() {
        webView.destroy()
        super.onDestroyView()
    }
}