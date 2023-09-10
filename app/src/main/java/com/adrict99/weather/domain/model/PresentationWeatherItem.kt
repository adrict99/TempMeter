package com.adrict99.weather.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
data class PresentationWeatherItem(
    val cityName: String?,
    val cityImage: String?,
    val weatherDataList: List<PresentationWeatherData?>?
) : Parcelable
