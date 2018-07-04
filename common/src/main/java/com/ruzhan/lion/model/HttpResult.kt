package com.ruzhan.lion.model

import com.google.gson.annotations.SerializedName

/**
 * Created by ruzhan123 on 2018/7/4.
 */
data class HttpResult<T>(
    @SerializedName("code")
    var code: Int = 0,
    @SerializedName("message")
    var message: String? = null,
    @SerializedName("data")
    var data: T? = null
)
