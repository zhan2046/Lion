package com.ruzhan.lion.model

import com.google.gson.annotations.SerializedName

/**
 * Created by ruzhan123 on 2018/7/5.
 */
data class Introduce (

    @SerializedName("type")
    var type: Int? = null,
    @SerializedName("text")
    var text: String? = null,
    @SerializedName("image")
    var image: String? = null
) {
    companion object {

        val TEXT = 1000
        val IMAGE = 1001
    }
}