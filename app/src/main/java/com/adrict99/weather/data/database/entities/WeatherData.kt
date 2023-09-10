package com.adrict99.weather.data.database.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherData(
    val date: String?,
    val temp: String?,
) : Parcelable
