package com.future.media.model

interface BaseMediaModel {

    fun getMediaId(): String?

    fun getMediaTitle(): String?

    fun getMediaUrl(): String?

    fun getMediaImageUrl(): String?
}