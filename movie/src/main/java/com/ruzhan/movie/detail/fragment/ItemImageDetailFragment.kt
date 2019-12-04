package com.ruzhan.movie.detail.fragment

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.lion.imageloader.glide.ImageLoader
import com.ruzhan.movie.utils.LionUtils
import com.ruzhan.movie.utils.ViewUtils
import com.ruzhan.movie.R
import kotlinx.android.synthetic.main.lion_frag_image_item_detail.*

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

    private var imageUrl = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageUrl = arguments?.getString(IMAGE_URL) ?: ""
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.lion_frag_image_item_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val isGif = imageUrl.contains(LionUtils.GIF_FILE)
        lion_image_photo_view.visibility = if (isGif) View.GONE else View.VISIBLE
        lion_image_image_iv.visibility = if (isGif) View.VISIBLE else View.GONE
        if (isGif) {
            ImageLoader.get().load(lion_image_image_iv, imageUrl,
                    ViewUtils.getPlaceholder(activity!!, 0))
            lion_image_load_progress.visibility = View.INVISIBLE
        } else {
            ImageLoader.get().load(lion_image_photo_view, imageUrl,
                    object : RequestListener<Drawable> {

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