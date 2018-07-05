package com.ruzhan.lion.model

import com.google.gson.annotations.SerializedName

/**
 * Created by ruzhan123 on 2018/7/5.
 */
data class Introduce (

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