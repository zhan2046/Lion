package com.ruzhan.movie.detail

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.ruzhan.lion.glide.ImageLoader
import com.ruzhan.movie.R
import kotlinx.android.synthetic.main.frag_image_detail.*

/**
 * Created by ruzhan123 on 2018/7/25.
 */
class ItemImageDetailFragment : Fragment() {

    companion object {

        private const val IMAGE_URL: String = "IMAGE_URL"

        @JvmStatic
        fun newInstance(imageUrl: String): ItemImageDetailFragment {
            val args = Bundle()
            args.putString(IMAGE_URL, imageUrl)
            val frag = ItemImageDetailFragment()
            frag.arguments = args
            return frag
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_image_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val imageUrl: String = it.getString(IMAGE_URL)

            ImageLoader.get().loadNoCrossFadeCenterCrop(photo_view, imageUrl, object : RequestListener<Drawable> {

                override fun onResourceReady(resource: Drawable?, model: Any?,
                                             target: Target<Drawable>?, dataSource: DataSource?,
                                             isFirstResource: Boolean): Boolean {
                    photo_view.setImageDrawable(resource)
                    load_progress.visibility = View.INVISIBLE
                    return true
                }

                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?,
                                          isFirstResource: Boolean): Boolean {
                    load_progress.visibility = View.INVISIBLE
                    return true
                }

            })

        }
    }
}