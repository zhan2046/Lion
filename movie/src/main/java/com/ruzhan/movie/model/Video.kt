package com.ruzhan.movie.model

data class Video(

        var id: String,
        var title: String,
        var image: String,
        var playCount: String,
        var playNumber: Int,
        var playNumberDesc: String,
        var playWebUrl: String,
        var m3u8Url: String? = null
)