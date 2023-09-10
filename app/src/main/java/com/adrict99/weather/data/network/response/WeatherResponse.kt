package com.adrict99.weather.data.network.response

import com.adrict99.weather.data.database.entities.WeatherEntity
import com.adrict99.weather.util.formatDate
import com.adrict99.weather.util.formatToCelsiusInt

class WeatherResponse : ArrayList<WeatherResponseItem>()

fun WeatherResponse.toDatabaseModel(): List<WeatherEntity> {
    var id = 0
    return this.groupBy { it.city.name }
        .map { mapItem ->
            val tempList = mapItem.value.map { it.temp.formatToCelsiusInt(it.tempType) }
            val datesList = mapItem.value.map { it.date }
            val dataMap = datesList.zip(tempList).toMap(linkedMapOf())
            val firstItem = mapItem.value.first()
            id++
            WeatherEntity(
                id = id,
                cityName = firstItem.city.name,
                cityImage = firstItem.city.picture,
                date = firstItem.date.formatDate(),
                dataMap = dataMap
            )
        }
}
