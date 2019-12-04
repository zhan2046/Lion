package com.ruzhan.movie.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ruzhan.movie.model.Introduce
import com.ruzhan.movie.model.Video
import java.io.Serializable

@Entity(tableName = "movie_detail_entity")
data class MovieDetailEntity(
        @PrimaryKey
        var id: String,
        var movieId: String,
        var title: String,
        var tag: String,
        var desc: String,
        var image: String,
        var introduces: ArrayList<Introduce> = ArrayList(),
        var videos: ArrayList<Video>  = ArrayList()
) : Serializable {

    companion object {

        @JvmStatic
        fun empty(): MovieDetailEntity = MovieDetailEntity(
                "", "", "",
                "", "", "",
                ArrayList(), ArrayList())
    }
}