package com.example.mausamweatherapp.data.remote.dto.response_by_lat_lon


import com.google.gson.annotations.SerializedName

data class Sys(
    @SerializedName("country")
    val country: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("sunrise")
    val sunrise: Int = 0,
    @SerializedName("sunset")
    val sunset: Int = 0,
    @SerializedName("type")
    val type: Int = 0
)