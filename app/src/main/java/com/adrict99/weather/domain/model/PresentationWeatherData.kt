package com.adrict99.weather.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PresentationWeatherData(
    val date: String?,
    val temp: String?,
) : Parcelable
