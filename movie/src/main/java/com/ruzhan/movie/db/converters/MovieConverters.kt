package com.ruzhan.movie.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ruzhan.movie.model.Introduce
import com.ruzhan.movie.model.Video

class MovieConverters {

    companion object {

        @TypeConverter
        @JvmStatic
        fun getIntroduceList(json: String): ArrayList<Introduce> {
            val listType = object : TypeToken<ArrayList<Introduce>>() {}.type
            return Gson().fromJson(json, listType)
        }

        @TypeConverter
        @JvmStatic
        fun converterIntroduceList(list: ArrayList<Introduce>): String {
            return Gson().toJson(list)
        }

        @TypeConverter
        @JvmStatic
        fun getVideoList(json: String): ArrayList<Video> {
            val listType = object : TypeToken<ArrayList<Video>>() {}.type
            return Gson().fromJson(json, listType)
        }

        @TypeConverter
        @JvmStatic
        fun converterVideoList(list: ArrayList<Video>): String {
            return Gson().toJson(list)
        }
    }
}