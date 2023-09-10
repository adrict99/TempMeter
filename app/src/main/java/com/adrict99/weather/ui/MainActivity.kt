package com.adrict99.weather.ui

import android.os.Bundle
import androidx.navigation.findNavController
import com.adrict99.weather.R
import com.adrict99.weather.databinding.ActivityMainBinding
import com.adrict99.weather.ui.common.BaseActivity
import dagger.android.AndroidInjection

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
    }

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

}