package com.adrict99.weather.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.adrict99.weather.data.database.WeatherDB
import com.adrict99.weather.util.NetworkUtils
import com.adrict99.weather.util.navigation.Navigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun providesAppContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun providesNavigator(): Navigator {
        return Navigator()
    }

    @Provides
    @Singleton
    fun providesNetWorkUtilities(context: Context): NetworkUtils {
        return NetworkUtils(context)
    }

    @Provides
    @Singleton
    fun provideDatabase(application: Application) : WeatherDB =
        Room.databaseBuilder(application, WeatherDB::class.java, "weather_db")
            .build()

}