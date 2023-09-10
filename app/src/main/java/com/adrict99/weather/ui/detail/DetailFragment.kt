package com.adrict99.weather.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgsLazy
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.adrict99.weather.R
import com.adrict99.weather.data.database.entities.WeatherEntity
import com.adrict99.weather.databinding.FragmentDetailBinding
import com.adrict99.weather.ui.common.BaseFragment
import com.adrict99.weather.ui.detail.adapter.TemperaturesAdapter
import com.adrict99.weather.ui.home.adapter.WeatherAdapter
import com.adrict99.weather.util.fromUrl
import com.adrict99.weather.util.setupAdapter
import javax.inject.Inject

class DetailFragment : BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail) {

    private val args: DetailFragmentArgs by navArgs()
    lateinit var weatherData: WeatherEntity

    private val temperaturesAdapter: TemperaturesAdapter by lazy {
        TemperaturesAdapter(
            requireContext()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
        handleArguments()
        setupView()
    }

    private fun handleArguments() {
        weatherData = WeatherEntity(
            id = 0,
            cityName = args.weatherData.cityName,
            cityImage = args.weatherData.cityImage,
            date = args.weatherData.date,
            dataMap = args.weatherData.dataMap
        )
    }

    private fun setupView() {
        binding.apply {
            weatherData.cityImage?.let { fragmentDetailImageView.fromUrl(it) }
            fragmentDetailCityNameTextView.text = weatherData.cityName
            fragmentDetailDateTextView.text = weatherData.date
            fragmentDetailTemperaturesRecyclerView.apply {
                setupAdapter(LinearLayoutManager.VERTICAL, true, 32)
                adapter = temperaturesAdapter
            }
            temperaturesAdapter.addAll(weatherData.dataMap)
        }
    }

}