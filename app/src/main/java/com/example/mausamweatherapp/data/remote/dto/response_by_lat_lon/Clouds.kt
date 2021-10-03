package com.example.mausamweatherapp.data.remote.dto.response_by_lat_lon


import com.google.gson.annotations.SerializedName

data class Clouds(
    @SerializedName("all")
    val all: Int = 0
)