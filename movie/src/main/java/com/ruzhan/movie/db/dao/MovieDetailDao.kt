package com.ruzhan.movie.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ruzhan.movie.db.entity.MovieDetailEntity
import com.ruzhan.movie.db.entity.MovieEntity
import io.reactivex.Flowable

@Dao
interface MovieDetailDao {

    @Query("SELECT * FROM movie_detail_entity WHERE movieId = :movieId")
    fun loadMovieDetailEntity(movieId: String): Flowable<MovieDetailEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieDetailEntity(movieDetailEntity: MovieDetailEntity)
}