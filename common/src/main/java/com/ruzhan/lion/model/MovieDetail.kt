package com.ruzhan.lion.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by ruzhan123 on 2018/7/4.
 */
data class MovieDetail(

        @SerializedName("id")
        var id: String? = null,
        @SerializedName("movieId")
        var movieId: String? = null,
        @SerializedName("title")
        var title: String? = null,
        @SerializedName("tag")
        var tag: String? = null,
        @SerializedName("desc")
        var desc: String? = null,
        @SerializedName("image")
        var image: String? = null,

        @SerializedName("introduces")
        var introduces: List<Introduce>? = null,
        @SerializedName("videos")
        var videos: List<Video>? = null
) : Serializable

