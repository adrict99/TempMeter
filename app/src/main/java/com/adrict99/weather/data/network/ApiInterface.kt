package com.adrict99.weather.data.network

import com.adrict99.weather.data.network.response.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("weather")
    suspend fun getWeather(): Response<WeatherResponse>

}