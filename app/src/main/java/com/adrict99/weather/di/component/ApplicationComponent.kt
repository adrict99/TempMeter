package com.adrict99.weather.di.component

import android.app.Application
import com.adrict99.weather.ApplicationInit
import com.adrict99.weather.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,
    AppModule::class,
    NetworkModule::class,
    ActivityModule::class,
    FragmentModule::class,
    RepositoryModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(applicationInit: ApplicationInit)

}