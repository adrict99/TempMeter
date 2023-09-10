package com.adrict99.weather.util

import android.widget.ImageView
import com.adrict99.weather.BuildConfig
import com.bumptech.glide.Glide

fun ImageView.fromUrl(url: String) {
    if (url.isNotEmpty()) {
        Glide.with(this)
            .load(url)
            .centerCrop()
            .into(this)
    }
}