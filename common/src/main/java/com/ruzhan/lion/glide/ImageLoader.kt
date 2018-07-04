package com.ruzhan.lion.glide

/**
 * Created by ruzhan123 on 2018/7/4.
 */
class ImageLoader {

    companion object {

        private var INSTANCE: IImageLoader? = null

        @JvmStatic
        fun get(): IImageLoader {
            if (INSTANCE == null) {
                synchronized(ImageLoader::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = GlideImpl()
                    }
                }
            }
            return this.INSTANCE!!
        }
    }

}