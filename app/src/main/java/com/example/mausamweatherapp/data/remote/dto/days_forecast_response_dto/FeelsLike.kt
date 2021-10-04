package com.example.mausamweatherapp.data.remote.dto.days_forecast_response_dto


import com.google.gson.annotations.SerializedName

data class FeelsLike(
    @SerializedName("day")
    val day: Double = 0.0,
    @SerializedName("eve")
    val eve: Double = 0.0,
    @SerializedName("morn")
    val morn: Double = 0.0,
    @SerializedName("night")
    val night: Double = 0.0
)