package com.example.mausamweatherapp.data.remote.dto.hourly_forecast_dto


import com.google.gson.annotations.SerializedName

data class WeatherX(
    @SerializedName("description")
    val description: String = "",
    @SerializedName("icon")
    val icon: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("main")
    val main: String = ""
)