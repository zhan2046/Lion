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
import com.ruzhan.lion.util.LionUtils
import com.ruzhan.lion.util.ViewUtils
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

            val isGif = imageUrl.contains(LionUtils.GIF_FILE)

            lion_image_photo_view.visibility = if (isGif) View.GONE else View.VISIBLE
            lion_image_image_iv.visibility = if (isGif) View.VISIBLE else View.GONE

            if (isGif) {
                ImageLoader.get().load(lion_image_image_iv, imageUrl, ViewUtils.getPlaceholder(activity!!, 0))
                lion_image_load_progress.visibility = View.INVISIBLE

            } else {
                ImageLoader.get().loadCenterCrop(lion_image_photo_view, imageUrl, object : RequestListener<Drawable> {

                    override fun onResourceReady(resource: Drawable?, model: Any?,
                                                 target: Target<Drawable>?, dataSource: DataSource?,
                                                 isFirstResource: Boolean): Boolean {
                        if (lion_image_photo_view != null) {
                            lion_image_photo_view.setImageDrawable(resource)
                            lion_image_load_progress.visibility = View.INVISIBLE
                        }
                        return true
                    }

                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?,
                                              isFirstResource: Boolean): Boolean {
                        if (lion_image_load_progress != null) {
                            lion_image_load_progress.visibility = View.INVISIBLE
                        }
                        return true
                    }

                })
            }
        }
    }
}