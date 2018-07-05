package com.ruzhan.lion.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by ruzhan123 on 2018/7/4.
 */
data class Movie(

        @SerializedName("id")
        var id: String,
        @SerializedName("title")
        var title: String,
        @SerializedName("tag")
        var tag: String,
        @SerializedName("desc")
        var desc: String,
        @SerializedName("image")
        var image: String

) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(id)
        writeString(title)
        writeString(tag)
        writeString(desc)
        writeString(image)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Movie> = object : Parcelable.Creator<Movie> {
            override fun createFromParcel(source: Parcel): Movie = Movie(source)
            override fun newArray(size: Int): Array<Movie?> = arrayOfNulls(size)
        }
    }
}
