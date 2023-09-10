package com.adrict99.weather.ui.home.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.adrict99.weather.R
import com.adrict99.weather.data.database.entities.WeatherEntity
import com.adrict99.weather.databinding.ItemWeatherBinding
import com.adrict99.weather.domain.model.PresentationWeatherItem
import com.adrict99.weather.util.averageAsInt
import com.adrict99.weather.util.formatDate
import com.adrict99.weather.util.fromUrl

class WeatherAdapter(
    private val context: Context,
    private val listener: OnClickListener
) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    private var weatherData = mutableListOf<WeatherEntity>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WeatherAdapter.WeatherViewHolder {
        val binding = ItemWeatherBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherAdapter.WeatherViewHolder, position: Int) {
        holder.bindItem(weatherData[position])
    }

    override fun getItemCount(): Int = weatherData.size

    fun addAll(results: List<WeatherEntity>?) {
        weatherData.clear()
        results?.let { weatherData.addAll(it) }
        notifyDataSetChanged()
    }

    inner class WeatherViewHolder(
        private val binding: ItemWeatherBinding
    ) : RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {
        fun bindItem(
            item: WeatherEntity
        ) {
            binding.apply {
                item.cityImage?.let { itemWeatherImageView.fromUrl(it) }
                itemWeatherNameTextView.text = item.cityName
                itemWeatherTemperatureTextView.text =
                    context.resources.getString(
                        R.string.average_temperature,
                        item.dataMap.values.toList().averageAsInt()
                    )
                itemWeatherDateTextView.text =
                    context.resources.getString(
                        R.string.date,
                        item.date
                    )
            }
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            listener.onWeatherClicked(weatherData[this.layoutPosition])
        }
    }

    interface OnClickListener {
        fun onWeatherClicked(weather: WeatherEntity)
    }

    inner class WeatherComparator : DiffUtil.ItemCallback<PresentationWeatherItem>() {
        override fun areItemsTheSame(
            oldItem: PresentationWeatherItem,
            newItem: PresentationWeatherItem
        ) = oldItem.cityName == newItem.cityName

        override fun areContentsTheSame(
            oldItem: PresentationWeatherItem,
            newItem: PresentationWeatherItem
        ) = oldItem == newItem

    }

}