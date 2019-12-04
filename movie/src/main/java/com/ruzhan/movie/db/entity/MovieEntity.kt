package com.ruzhan.movie.db.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
@Entity(tableName = "movie_entity")
data class MovieEntity(
        @PrimaryKey
        var id: String,
        @ColumnInfo(name = "title")
        var title: String,
        @ColumnInfo(name = "tag")
        var tag: String,
        @ColumnInfo(name = "desc")
        var desc: String,
        @ColumnInfo(name = "image")
        var image: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(tag)
        parcel.writeString(desc)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieEntity> {
        override fun createFromParcel(parcel: Parcel): MovieEntity {
            return MovieEntity(parcel)
        }

        override fun newArray(size: Int): Array<MovieEntity?> {
            return arrayOfNulls(size)
        }
    }
}