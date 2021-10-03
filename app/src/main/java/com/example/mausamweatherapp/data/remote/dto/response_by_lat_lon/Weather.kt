package com.example.mausamweatherapp.data.remote.dto.response_by_lat_lon


import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("description")
    val description: String = "",
    @SerializedName("icon")
    val icon: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("main")
    val main: String = ""
)