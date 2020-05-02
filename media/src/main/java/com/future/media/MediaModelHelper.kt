package com.future.media

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.os.Process
import android.support.v4.media.MediaMetadataCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ConcatenatingMediaSource
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.future.media.model.BaseMediaModel
import com.future.media.MediaSourceListener

class MediaModelHelper(private val context: Context) {

    companion object {

        private const val HTTP = "http"
        private const val HTTPS = "https"
        private const val EMPTY_MEDIA_ID = "EMPTY_MEDIA_ID"
        private const val EMPTY_MEDIA_URL = "EMPTY_MEDIA_URL"
        private const val NOTIFICATION_LARGE_ICON_SIZE = 144 // px

        @JvmStatic
        fun getMediaId(metadata: MediaMetadataCompat): String {
            val currentId = metadata.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID)
                    ?: EMPTY_MEDIA_ID
            val mediaUrl = metadata.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_URI)
                    ?: EMPTY_MEDIA_URL
            return createMediaId(currentId, mediaUrl)
        }

        @JvmStatic
        fun createMediaId(id: String?, audio: String?): String {
            val currentId = id ?: EMPTY_MEDIA_ID
            val mediaUrl = audio ?: EMPTY_MEDIA_URL
            return mediaUrl.plus(currentId)
        }

        @JvmStatic
        fun getMediaId(baseMediaModel: BaseMediaModel): String {
            return createMediaId(baseMediaModel.getMediaId(), baseMediaModel.getMediaUrl())
        }

        @JvmStatic
        fun isMediaPrevious(mediaMetadata: MediaMetadataCompat): Boolean {
            var isMediaPrevious = false
            val firstPosition = 0
            val mediaId = getMediaId(mediaMetadata)
            val mediaList = MediaDataSource.get().getMediaList()
            if (mediaList.isNotEmpty()) {
                isMediaPrevious = mediaId == getMediaId(mediaList[firstPosition])
            }
            return isMediaPrevious
        }
    }

    private val mainHandler = Handler(Looper.getMainLooper())
    private val handlerThread = HandlerThread("MediaModelHelper",
            Process.THREAD_PRIORITY_BACKGROUND)
    private val workHandler: Handler

    private val mediaSourceWorkTask = MediaSourceWorkTask()
    private val mediaSourceTask = MediaSourceTask()

    private val glideOptions = RequestOptions()
            .fallback(R.drawable.media_shape_default_art)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)

    private val defaultExtractorsFactory = DefaultExtractorsFactory().also {
        it.setConstantBitrateSeekingEnabled(true)
    }

    init {
        handlerThread.start()
        workHandler = Handler(handlerThread.looper)
    }

    fun getConcatenatingMediaSource(list: List<BaseMediaModel>,
                                    dataSourceFactory: DataSource.Factory,
                                    listener: MediaSourceListener) {
        mediaSourceTask.listener = listener
        mediaSourceWorkTask.list = ArrayList(list)
        mediaSourceWorkTask.dataSourceFactory = dataSourceFactory
        workHandler.post(mediaSourceWorkTask)
    }

    private fun getExtractorMediaSource(baseMediaModel: BaseMediaModel, factory: DataSource.Factory):
            ExtractorMediaSource {
        val url = baseMediaModel.getMediaImageUrl()
        val albumBitmap = getAlbumBitmap(context, url)
                ?: BitmapFactory.decodeResource(context.resources, R.drawable.player_placeholder)
        val mediaMetadataCompat = MediaMetadataCompat.Builder()
                .putString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID, baseMediaModel.getMediaId())
                .putString(MediaMetadataCompat.METADATA_KEY_TITLE, baseMediaModel.getMediaTitle())
                .putString(MediaMetadataCompat.METADATA_KEY_MEDIA_URI, baseMediaModel.getMediaUrl())
                .putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON_URI, baseMediaModel.getMediaImageUrl())
                .putBitmap(MediaMetadataCompat.METADATA_KEY_ALBUM_ART, albumBitmap)
                .build()
        mediaMetadataCompat.description.extras?.putAll(mediaMetadataCompat.bundle)
        return ExtractorMediaSource.Factory(factory)
                .setTag(mediaMetadataCompat.description)
                .setExtractorsFactory(defaultExtractorsFactory)
                .createMediaSource(Uri.parse(baseMediaModel.getMediaUrl() ?: ""))
    }

    private fun getAlbumBitmap(context: Context, url: String?): Bitmap? {
        return if (isImageUrl(url)) {
            Glide.with(context).applyDefaultRequestOptions(glideOptions)
                    .asBitmap()
                    .load(url)
                    .submit(NOTIFICATION_LARGE_ICON_SIZE, NOTIFICATION_LARGE_ICON_SIZE)
                    .get()
        } else {
            Glide.with(context).applyDefaultRequestOptions(glideOptions)
                    .asBitmap()
                    .load(R.drawable.player_placeholder)
                    .submit(NOTIFICATION_LARGE_ICON_SIZE, NOTIFICATION_LARGE_ICON_SIZE)
                    .get()
        }
    }

    private fun isImageUrl(url: String?): Boolean {
        return url != null && url.isNotBlank() && (url.startsWith(HTTP) || url.startsWith(HTTPS))
    }

    fun clear() {
        workHandler.removeCallbacks(mediaSourceWorkTask)
        mainHandler.removeCallbacks(mediaSourceTask)
        handlerThread.quit()
    }

    inner class MediaSourceWorkTask : Runnable {

        var list: List<BaseMediaModel>? = null
        var dataSourceFactory: DataSource.Factory? = null

        override fun run() {
            val list = list
            val dataSourceFactory = dataSourceFactory
            if (list != null && dataSourceFactory != null) {
                val concatenatingMediaSource = ConcatenatingMediaSource()
                for (item in list) {
                    concatenatingMediaSource.addMediaSource(getExtractorMediaSource(item, dataSourceFactory))
                }
                mediaSourceTask.mediaSource = concatenatingMediaSource
                mainHandler.post(mediaSourceTask)
            }
        }
    }

    inner class MediaSourceTask : Runnable {

        var listener: MediaSourceListener? = null
        var mediaSource: ConcatenatingMediaSource? = null

        override fun run() {
            val listener = listener
            val mediaSource = mediaSource
            if (listener != null && mediaSource != null) {
                listener.onMediaSourceSuccess(mediaSource)
            }
        }
    }
}