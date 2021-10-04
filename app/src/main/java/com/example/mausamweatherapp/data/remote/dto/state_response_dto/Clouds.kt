package com.example.mausamweatherapp.data.remote.dto.state_response_dto


import com.google.gson.annotations.SerializedName

data class Clouds(
    @SerializedName("all")
    val all: Int = 0
)