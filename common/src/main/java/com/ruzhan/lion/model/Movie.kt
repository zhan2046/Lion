package com.ruzhan.lion.model

import com.google.gson.annotations.SerializedName

/**
 * Created by ruzhan123 on 2018/7/4.
 */
data class Movie (
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("tag")
    var tag: String? = null,
    @SerializedName("desc")
    var desc: String? = null,
    @SerializedName("image")
    var image: String? = null
)
