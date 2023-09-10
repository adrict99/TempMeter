package com.adrict99.weather.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adrict99.weather.data.database.entities.WeatherEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDAO {

    @Query("SELECT * FROM weather_table ORDER BY cityName ASC")
    fun getAllItems(): Flow<List<WeatherEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(weatherItemsList: List<WeatherEntity>?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(weatherItem: WeatherEntity)

    @Query("DELETE FROM weather_table")
    suspend fun deleteAllItems()

}