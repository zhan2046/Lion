package com.ruzhan.movie.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ruzhan.movie.db.entity.MovieEntity
import io.reactivex.Flowable

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_entity ORDER BY id DESC LIMIT :startIndex,:endIndex")
    fun loadMovieEntityList(startIndex: Int, endIndex: Int): Flowable<List<MovieEntity>>

    @Query("SELECT * FROM movie_entity WHERE tag=:tag ORDER BY id DESC LIMIT :startIndex,:endIndex")
    fun loadMovieEntityList(startIndex: Int, endIndex: Int, tag: String): Flowable<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieEntityList(dayNewList: List<MovieEntity>)
}