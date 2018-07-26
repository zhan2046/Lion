package com.ruzhan.movie

import java.io.Serializable

/**
 * Created by ruzhan123 on 2018/7/25.
 */
data class ImageListModel(

        var title: String,
        var position: Int,
        var url: String,
        var imageList: ArrayList<String>
) : Serializable