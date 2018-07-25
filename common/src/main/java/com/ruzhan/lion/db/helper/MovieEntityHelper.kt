package com.ruzhan.lion.db.helper

import com.ruzhan.lion.db.entity.MovieEntity
import com.ruzhan.lion.model.Movie

/**
 * Created by ruzhan123 on 2018/7/25.
 */
object MovieEntityHelper {

    fun toMovieEntity(movie: Movie): MovieEntity {
        return MovieEntity(movie.id, movie.title, movie.tag,
                movie.desc, movie.image)
    }

    fun toMovie(movieEntity: MovieEntity): Movie {
        return Movie(movieEntity.id, movieEntity.title, movieEntity.tag,
                movieEntity.desc, movieEntity.image)
    }

    fun toMovieEntityList(movieList: List<Movie>): List<MovieEntity> {
        val movieEntityList: ArrayList<MovieEntity> = ArrayList()
        for (item in movieList) {
            val movieEntity: MovieEntity = toMovieEntity(item)
            movieEntityList.add(movieEntity)
        }
        return movieEntityList
    }

    fun toMovieList(movieEntityList: List<MovieEntity>): List<Movie> {
        val movieList: ArrayList<Movie> = ArrayList()
        for (item in movieEntityList) {
            val movie: Movie = toMovie(item)
            movieList.add(movie)
        }
        return movieList
    }
}