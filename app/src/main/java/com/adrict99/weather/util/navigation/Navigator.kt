package com.adrict99.weather.util.navigation

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.adrict99.weather.data.database.entities.WeatherEntity
import com.adrict99.weather.ui.MainActivity
import com.adrict99.weather.ui.common.BaseActivity
import com.adrict99.weather.ui.home.HomeFragmentDirections

class Navigator {

    fun navigate(context: Context, intent: Intent?, options: ActivityOptionsCompat) {
        (context as BaseActivity<*>).startActivity(intent, options.toBundle())
    }

    private fun navigate(context: Context, intent: Intent?) {
        (context as Activity).startActivity(intent)
    }

    fun goToMainActivity(context: Context) {
        val intent = Intent(context, MainActivity::class.java)
        navigate(context, intent)
    }

    fun goToDetailFragment(
        data: WeatherEntity,
        originFragment: Fragment
    ) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(
            weatherData = data
        )
        originFragment.findNavController().navigate(action)
    }

}