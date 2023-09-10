package com.adrict99.weather.ui.detail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adrict99.weather.databinding.ItemTemperatureBinding
import com.adrict99.weather.util.formatDate
import com.adrict99.weather.util.formatHour
import com.adrict99.weather.util.formatToCelsius

class TemperaturesAdapter(
    private val context: Context
) : RecyclerView.Adapter<TemperaturesAdapter.TemperaturesViewHolder>() {

    private var temperaturesMap: LinkedHashMap <String, Int> = linkedMapOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TemperaturesAdapter.TemperaturesViewHolder {
        val binding = ItemTemperatureBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return TemperaturesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TemperaturesAdapter.TemperaturesViewHolder, position: Int) {
        holder.bindItem(temperaturesMap.entries.elementAt(position))
    }

    override fun getItemCount(): Int = temperaturesMap.size

    fun addAll(results: Map<String, Int>) {
        val sortedTemperaturesMap = results.toList()
            .sortedBy { (key, _) -> key }
            .toMap(linkedMapOf())

        temperaturesMap = LinkedHashMap(sortedTemperaturesMap)
        notifyDataSetChanged()
    }

    inner class TemperaturesViewHolder(
        private val binding: ItemTemperatureBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(
            item: MutableMap.MutableEntry<String, Int>
        ) {
            binding.apply {
                itemTemperatureHourTextView.text = item.key.formatHour()
                itemTemperatureTextView.text = item.value.formatToCelsius("C")
            }
        }

    }

}