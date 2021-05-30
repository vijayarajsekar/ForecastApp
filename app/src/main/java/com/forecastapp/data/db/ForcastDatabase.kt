package com.forecastapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.forecastapp.data.db.entity.CurrentWeather
import com.forecastapp.utils.AppTypeConverters

@Database(
    entities = [CurrentWeather::class],
    version = 1
)
@TypeConverters(AppTypeConverters::class)
abstract class ForcastDatabase : RoomDatabase() {

    abstract fun currentWeatherDao(): CurrentWeatherDao

    companion object {
        @Volatile
        private var instance: ForcastDatabase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ForcastDatabase::class.java, "Forcast.db"
            ).build()
    }
}