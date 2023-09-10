package com.adrict99.weather.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.adrict99.weather.R
import com.adrict99.weather.data.database.entities.WeatherEntity
import com.adrict99.weather.data.network.status.Resource
import com.adrict99.weather.databinding.FragmentHomeBinding
import com.adrict99.weather.ui.common.BaseFragment
import com.adrict99.weather.ui.common.BaseViewModel
import com.adrict99.weather.ui.home.adapter.WeatherAdapter
import com.adrict99.weather.util.ViewModelFactory
import com.adrict99.weather.util.setupAdapter
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home),
    WeatherAdapter.OnClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<HomeViewModel>
    private val viewModel: HomeViewModel by lazy { viewModelFactory.get() }

    private val weatherAdapter: WeatherAdapter by lazy { WeatherAdapter(requireContext(), this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        setupView()
        setupViewModelObservers()
    }

    private fun setupView() {
        binding.fragmentHomeRecyclerView.apply {
            setupAdapter(LinearLayoutManager.VERTICAL, true, 32)
            adapter = weatherAdapter
        }
        binding.fragmentHomeSwipeRefreshList.apply {
            setOnRefreshListener {
                //TODO: Make this reload data
                isRefreshing = false
            }
        }
    }

    private fun setupViewModelObservers() {
        viewModel.weatherData.observe(viewLifecycleOwner) { result ->
            weatherAdapter.addAll(result.data)
            when (result) {
                is Resource.Loading -> {
                    viewModel.loading.value = BaseViewModel.SHOW
                }
                is Resource.Success -> {
                    viewModel.loading.value = BaseViewModel.DISMISS
                }
                is Resource.Error -> {
                    viewModel.loading.value = BaseViewModel.DISMISS
                }
            }

            binding.fragmentHomeSwipeRefreshList.isRefreshing = false
        }
    }

    override fun onWeatherClicked(weather: WeatherEntity) {
        navigator.goToDetailFragment(
            data = weather,
            this
        )
    }

}
