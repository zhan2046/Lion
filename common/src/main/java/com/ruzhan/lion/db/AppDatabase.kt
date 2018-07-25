package com.ruzhan.lion.db

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import android.support.annotation.VisibleForTesting

import com.ruzhan.lion.db.converter.RoomDataConverter
import com.ruzhan.lion.db.dao.MovieEntityDao
import com.ruzhan.lion.db.entity.MovieEntity

@Database(entities = [(MovieEntity::class)], version = 1, exportSchema = false)
@TypeConverters(RoomDataConverter::class)
abstract class AppDatabase : RoomDatabase() {

    private val isDatabaseCreated = MutableLiveData<Boolean>()

    val databaseCreated: LiveData<Boolean>
        get() = isDatabaseCreated

    abstract fun movieEntityDao(): MovieEntityDao

    private fun updateDatabaseCreated(context: Context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            isDatabaseCreated.postValue(true)
        }
    }

    companion object {

        @VisibleForTesting
        val DATABASE_NAME = "lion-db"

        private var INSTANCE: AppDatabase? = null

        operator fun get(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                                .build()
                        INSTANCE!!.updateDatabaseCreated(context)
                    }
                }
            }
            return this.INSTANCE!!
        }
    }
}