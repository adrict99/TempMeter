package com.adrict99.weather.util

import androidx.room.TypeConverter

class WeatherDataListTypeConverter {

    @TypeConverter
    fun fromString(value: String): LinkedHashMap<String, Int> {
        val map = LinkedHashMap<String, Int>()
        value.split(",").forEach {
            val parts = it.split(" - ")
            map[parts[0]] = parts[1].toInt()
        }
        return map
    }

    @TypeConverter
    fun fromLinkedHashMap(map: LinkedHashMap<String, Int>): String =
        map.map { "${it.key} - ${it.value}" }.joinToString(",")


}
