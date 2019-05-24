package com.ruzhan.lion.glide

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