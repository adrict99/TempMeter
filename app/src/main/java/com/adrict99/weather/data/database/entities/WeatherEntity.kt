package com.adrict99.weather.data.database.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.adrict99.weather.util.WeatherDataListTypeConverter
import kotlinx.parcelize.Parcelize

@Entity(tableName = "weather_table")
@Parcelize
@TypeConverters(WeatherDataListTypeConverter::class)
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    var cityName: String?,
    var cityImage: String?,
    var date: String?,
    var dataMap: LinkedHashMap<String, Int>
) : Parcelable