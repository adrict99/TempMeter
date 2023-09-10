package com.adrict99.weather.ui.home

import androidx.lifecycle.asLiveData
import com.adrict99.weather.domain.repository.WeatherRepository
import com.adrict99.weather.ui.common.BaseViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    weatherRepository: WeatherRepository
) : BaseViewModel() {

    //Stores weather results
    val weatherData = weatherRepository.getWeatherFromDB().asLiveData()

}