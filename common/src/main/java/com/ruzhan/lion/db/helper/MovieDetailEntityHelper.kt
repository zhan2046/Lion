package com.ruzhan.lion.db.helper

import com.ruzhan.lion.db.entity.MovieDetailEntity
import com.ruzhan.lion.model.MovieDetail


/**
 * Created by ruzhan123 on 2018/7/25.
 */
object MovieDetailEntityHelper {

    fun toMovieDetailEntity(movieDetail: MovieDetail): MovieDetailEntity {
        return MovieDetailEntity(movieDetail.id, movieDetail.movieId, movieDetail.title,
                movieDetail.tag, movieDetail.desc, movieDetail.image,
                ArrayList(movieDetail.introduces), ArrayList(movieDetail.videos))
    }

    fun toMovieDetail(movieDetailEntity: MovieDetailEntity): MovieDetail {
        return MovieDetail(movieDetailEntity.id, movieDetailEntity.movieId, movieDetailEntity.title,
                movieDetailEntity.tag, movieDetailEntity.desc, movieDetailEntity.image,
                ArrayList(movieDetailEntity.introduces), ArrayList(movieDetailEntity.videos))
    }
}