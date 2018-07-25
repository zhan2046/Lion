package com.ruzhan.lion.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

/**
 * Created by ruzhan123 on 2018/7/25.
 */
@Entity(tableName = "movie_entity")
data class MovieEntity(

        @NonNull
        @PrimaryKey
        var id: String,

        var title: String,
        var tag: String,
        var desc: String,
        var image: String
)