package com.adrict99.weather.di.module

import com.adrict99.weather.ui.detail.DetailFragment
import com.adrict99.weather.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun bindsHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun bindsDetailFragment(): DetailFragment

}