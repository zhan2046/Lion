package com.ruzhan.lion.db.converter

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ruzhan.lion.db.entity.MovieEntity
import java.util.*


/**
 * Created by ruzhan123 on 2018/7/25.
 */
object RoomDataConverter {

    @TypeConverter
    fun toDate(timestamp: Long?): Date? {
        return if (timestamp == null) null else Date(timestamp)
    }

    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun toMovieEntityList(json: String): List<MovieEntity> {
        return Gson().fromJson<List<MovieEntity>>(json, object : TypeToken<List<MovieEntity>>() {}.type)
    }

    @TypeConverter
    fun toMovieEntityListJson(specialList: List<MovieEntity>): String {
        return Gson().toJson(specialList)
    }
}