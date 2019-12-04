package com.ruzhan.movie.helper

import com.ruzhan.movie.db.entity.MovieDetailEntity
import com.ruzhan.movie.db.entity.MovieEntity
import com.ruzhan.movie.model.Movie
import com.ruzhan.movie.model.MovieDetail

object MovieHelper {

    fun getMovieEntityList(list: List<Movie>?): ArrayList<MovieEntity> {
        val newList = ArrayList<MovieEntity>()
        if (list != null && list.isNotEmpty()) {
            for (bean in list) {
                newList.add(getMovieEntity(bean))
            }
        }
        return newList
    }

    private fun getMovieEntity(bean: Movie): MovieEntity {
        return MovieEntity(bean.id, bean.title, bean.tag, bean.desc, bean.image)
    }

    fun getMovieDetailEntity(bean: MovieDetail): MovieDetailEntity {
        return MovieDetailEntity(bean.id, bean.movieId, bean.title,
                bean.tag, bean.desc, bean.image, ArrayList(bean.introduces),
                ArrayList(bean.videos))
    }
}