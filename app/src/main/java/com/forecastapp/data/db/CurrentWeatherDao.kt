package com.forecastapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.forecastapp.data.db.entity.CURRENT_WEATER_ID
import com.forecastapp.data.db.entity.CurrentWeather

@Dao
interface CurrentWeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(currentWeather: CurrentWeather)

    @Query("select * from CurrentWeather where id= $CURRENT_WEATER_ID")
    fun getCurrentWeather(): LiveData<CurrentWeather>

}