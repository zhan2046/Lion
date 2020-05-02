package com.future.media

import com.future.media.model.BaseMediaModel

class MediaDataSource private constructor() {

    companion object {

        private var INSTANCE: MediaDataSource? = null

        @JvmStatic
        fun get() = INSTANCE ?: synchronized(this) {
            INSTANCE ?: MediaDataSource().also { INSTANCE = it }
        }
    }

    private val mediaList = ArrayList<BaseMediaModel>()

    fun setData(list: List<BaseMediaModel>) {
        mediaList.clear()
        mediaList.addAll(list)
    }

    fun getMediaModel(mediaId: String): BaseMediaModel? {
        return if (mediaList.isNotEmpty()) mediaList.find {
            MediaModelHelper.getMediaId(it) == mediaId
        } else null
    }

    fun getPosition(mediaId: String?): Int {
        val realMediaId = mediaId ?: ""
        var position = -1
        for (index in mediaList.indices) {
            val mediaModel = mediaList[index]
            if (MediaModelHelper.getMediaId(mediaModel) == realMediaId) {
                position = index
                break
            }
        }
        return position
    }

    fun getMediaList(): ArrayList<BaseMediaModel> = ArrayList(mediaList)

    fun clear() {
        mediaList.clear()
    }
}