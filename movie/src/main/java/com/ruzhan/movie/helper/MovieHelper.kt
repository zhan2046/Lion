package com.ruzhan.movie.helper

import com.ruzhan.lion.model.Movie
import com.ruzhan.movie.db.entity.MovieEntity

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
}