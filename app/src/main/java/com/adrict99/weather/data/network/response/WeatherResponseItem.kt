package com.adrict99.weather.data.network.response

import com.adrict99.weather.domain.model.City
import com.google.gson.annotations.SerializedName

data class WeatherResponseItem(
    @SerializedName("city")
    val city: City,
    @SerializedName("date")
    val date: String,
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("tempType")
    val tempType: String
)