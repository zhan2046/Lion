package com.ruzhan.lion.db.converter

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ruzhan.lion.db.entity.MovieEntity
import com.ruzhan.lion.model.Introduce
import com.ruzhan.lion.model.Video
import java.util.*

class RoomDataConverter {

    companion object {

        @JvmStatic
        @TypeConverter
        fun toDate(timestamp: Long?): Date? {
            return if (timestamp == null) null else Date(timestamp)
        }

        @JvmStatic
        @TypeConverter
        fun toTimestamp(date: Date?): Long? {
            return date?.time
        }

        @JvmStatic
        @TypeConverter
        fun toMovieEntityList(json: String): List<MovieEntity> {
            return Gson().fromJson<List<MovieEntity>>(json, object : TypeToken<List<MovieEntity>>() {}.type)
        }

        @JvmStatic
        @TypeConverter
        fun toMovieEntityListJson(specialList: List<MovieEntity>): String {
            return Gson().toJson(specialList)
        }

        @JvmStatic
        @TypeConverter
        fun toIntroduceList(json: String): List<Introduce> {
            return Gson().fromJson<List<Introduce>>(json, object : TypeToken<List<Introduce>>() {}.type)
        }

        @JvmStatic
        @TypeConverter
        fun toIntroduceListJson(introduceList: List<Introduce>): String {
            return Gson().toJson(introduceList)
        }

        @JvmStatic
        @TypeConverter
        fun toVideoList(json: String): List<Video> {
            return Gson().fromJson<List<Video>>(json, object : TypeToken<List<Video>>() {}.type)
        }

        @JvmStatic
        @TypeConverter
        fun toVideoListJson(videoList: List<Video>): String {
            return Gson().toJson(videoList)
        }
    }


}