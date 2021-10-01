package com.example.mausamweatherapp.data.remote.dto.stateResponseDto


import com.google.gson.annotations.SerializedName

data class Clouds(
    @SerializedName("all")
    val all: Int = 0
)