package com.adrict99.weather.domain.repository

import com.adrict99.weather.data.database.entities.WeatherEntity
import com.adrict99.weather.data.network.status.Resource
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    fun getWeatherFromDB(): Flow<Resource<List<WeatherEntity>>>

}