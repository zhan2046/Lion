package com.ruzhan.lion.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.ruzhan.lion.db.entity.MovieEntity
import io.reactivex.Flowable

/**
 * Created by ruzhan123 on 2018/7/25.
 */
@Dao
interface MovieEntityDao {

    @Query("SELECT * FROM movie_entity")
    fun loadMovieEntityList(): Flowable<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieEntityList(movieEntityList: List<MovieEntity>)
}