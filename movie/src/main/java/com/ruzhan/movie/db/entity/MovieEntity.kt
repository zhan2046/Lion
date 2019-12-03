package com.ruzhan.movie.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


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
)