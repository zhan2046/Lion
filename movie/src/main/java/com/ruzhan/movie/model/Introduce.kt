package com.ruzhan.movie.model

import com.google.gson.annotations.SerializedName

data class Introduce(

        @SerializedName("type")
        var type: Int,
        @SerializedName("text")
        var text: String,
        @SerializedName("image")
        var image: String
) {
    companion object {

        const val TEXT = 1000
        const val IMAGE = 1001
    }
}