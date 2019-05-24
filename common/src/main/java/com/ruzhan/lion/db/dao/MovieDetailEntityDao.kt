package com.ruzhan.lion.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.ruzhan.lion.db.entity.MovieDetailEntity
import io.reactivex.Flowable

@Dao
interface MovieDetailEntityDao {

    @Query("SELECT * FROM movie_detail_entity WHERE movieId = :movieId")
    fun loadMovieDetailEntity(movieId: String): Flowable<MovieDetailEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieDetailEntity(movieDetailEntity: MovieDetailEntity)
}