package com.adrict99.weather.di.module

import com.adrict99.weather.data.database.WeatherDB
import com.adrict99.weather.data.network.ApiInterface
import com.adrict99.weather.data.repository.WeatherRepositoryImpl
import com.adrict99.weather.domain.repository.WeatherRepository
import com.adrict99.weather.util.NetworkUtils
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun providesWeatherRepository(apiInterface: ApiInterface, networkUtils: NetworkUtils, database: WeatherDB): WeatherRepository {
        return WeatherRepositoryImpl(apiInterface, networkUtils, database)
    }

}