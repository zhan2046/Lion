package com.ruzhan.movie.model

import com.google.gson.annotations.SerializedName

data class HttpResult<T>(
        @SerializedName("code")
        var code: Int = 0,
        @SerializedName("message")
        var message: String? = null,
        @SerializedName("data")
        var data: T? = null
)
