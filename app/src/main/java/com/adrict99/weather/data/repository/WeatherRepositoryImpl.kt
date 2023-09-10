package com.adrict99.weather.data.repository

import android.util.Log
import androidx.room.withTransaction
import com.adrict99.weather.data.database.WeatherDB
import com.adrict99.weather.data.network.ApiInterface
import com.adrict99.weather.data.network.networkBoundResource
import com.adrict99.weather.data.network.response.toDatabaseModel
import com.adrict99.weather.domain.repository.WeatherRepository
import com.adrict99.weather.util.NetworkUtils
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface,
    override val networkUtils: NetworkUtils,
    private val db: WeatherDB
) : WeatherRepository, Repository(networkUtils) {

    private val weatherDao = db.getItemsDao()

    override fun getWeatherFromDB() = networkBoundResource(
        query = {
            weatherDao.getAllItems()
        },
        fetch = {
            apiInterface.getWeather()
        },
        saveFetchResult = { weatherResponse ->
            db.withTransaction {
                weatherDao.deleteAllItems()
                weatherDao.insertItems(weatherResponse.body()?.toDatabaseModel())
            }
        }
    )

}