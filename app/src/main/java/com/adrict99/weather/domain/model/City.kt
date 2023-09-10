package com.adrict99.weather.domain.model

import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("name")
    val name: String?,
    @SerializedName("picture")
    val picture: String?
)