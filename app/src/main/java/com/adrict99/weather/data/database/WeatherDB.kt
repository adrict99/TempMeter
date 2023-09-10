package com.adrict99.weather.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adrict99.weather.data.database.dao.WeatherDAO
import com.adrict99.weather.data.database.entities.WeatherEntity

@Database(
    entities = [WeatherEntity::class],
    version = 1,
    exportSchema = false
)
abstract class WeatherDB: RoomDatabase() {
    abstract fun getItemsDao(): WeatherDAO
}