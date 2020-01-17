package com.ruzhan.movie.video

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.ruzhan.movie.R
import kotlinx.android.synthetic.main.lion_frag_video.*

class VideoFragment : Fragment() {

    companion object {

        private const val M3U8_URL = "M3U8_URL"

        @JvmStatic
        fun newInstance(m3u8Url: String): VideoFragment {
            val args = Bundle()
            args.putString(M3U8_URL, m3u8Url)
            val frag = VideoFragment()
            frag.arguments = args
            return frag
        }
    }

    private var m3u8Url = ""
    private var simpleExoPlayer: SimpleExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        m3u8Url = arguments?.getString(M3U8_URL) ?: ""
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.lion_frag_video, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val activity = requireActivity()
        val player = SimpleExoPlayer.Builder(activity).build()
        this.simpleExoPlayer = player
        playerView.player = player
        val videoUri = Uri.parse(m3u8Url)
        val createdMediaSource =
                HlsMediaSource.Factory(DefaultHttpDataSourceFactory(activity.applicationInfo.packageName))
                        .createMediaSource(videoUri)
        player.prepare(createdMediaSource)
        player.playWhenReady = true
    }

    override fun onPause() {
        super.onPause()
        simpleExoPlayer?.stop()
    }

    override fun onDestroyView() {
        simpleExoPlayer?.release()
        super.onDestroyView()
    }
}