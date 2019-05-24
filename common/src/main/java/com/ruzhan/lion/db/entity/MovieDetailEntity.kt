package com.ruzhan.lion.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import android.support.annotation.NonNull
import com.ruzhan.lion.db.converter.RoomDataConverter
import com.ruzhan.lion.model.Introduce
import com.ruzhan.lion.model.Video

@Entity(tableName = "movie_detail_entity")
data class MovieDetailEntity (

        var id: String,

        @NonNull
        @PrimaryKey
        var movieId: String,

        var title: String,
        var tag: String,
        var desc: String,
        var image: String,

        @TypeConverters(RoomDataConverter::class)
        var introduces: List<Introduce>,

        @TypeConverters(RoomDataConverter::class)
        var videos: List<Video>
)