package com.adrict99.weather.util

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adrict99.weather.ui.common.MarginItemDecoration
import java.text.SimpleDateFormat
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.math.roundToInt

fun RecyclerView.setupAdapter(
    AxisMode: Int,
    verticalMode: Boolean,
    firstItemMargin: Int? = null,
) {
    layoutManager = LinearLayoutManager(context, AxisMode, false)
    setHasFixedSize(true)
    if (firstItemMargin != null) {
        addItemDecoration(MarginItemDecoration(firstItemMargin, verticalMode))
    }
}

fun Int.formatToCelsius(temperatureType: String?): String {
    return when (temperatureType) {
        "K" -> "${this.fromKelvinToCelsius()}ºC"
        "F" -> "${this.fromFahrenheitToCelsius()}ºC"
        else -> "${this}ºC"
    }
}

fun Double.formatToCelsiusInt(temperatureType: String): Int {
    return when (temperatureType) {
        "K" -> this.fromKelvinToCelsius()
        "F" -> this.fromFahrenheitToCelsius()
        else -> this.roundToInt()
    }
}

fun List<Int?>.averageAsInt(): Int {
    val nonNullList = this.filterNotNull()
    return (nonNullList.sumOf { it.toDouble() } / nonNullList.size).roundToInt()
}

fun Double.fromKelvinToCelsius(): Int = (this - 273.15).roundToInt()

fun Double.fromFahrenheitToCelsius(): Int = ((this - 32)/1.8).roundToInt()

fun Int.fromKelvinToCelsius(): Int = (this - 273.15).roundToInt()

fun Int.fromFahrenheitToCelsius(): Int = ((this - 32)/1.8).roundToInt()

fun String.formatDate(): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX")
    val outputFormat = SimpleDateFormat("dd-MM-yy")
    val date = inputFormat.parse(this)
    return outputFormat.format(date)
}

fun String.formatHour(): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX")
    val outputFormat = SimpleDateFormat("HH:mm")
    val date = inputFormat.parse(this)
    return outputFormat.format(date)
}