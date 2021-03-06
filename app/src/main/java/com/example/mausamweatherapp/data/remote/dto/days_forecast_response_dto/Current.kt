package com.example.mausamweatherapp.data.remote.dto.days_forecast_response_dto


import com.google.gson.annotations.SerializedName

data class Current(
    @SerializedName("clouds")
    val clouds: Int = 0,
    @SerializedName("dew_point")
    val dewPoint: Double = 0.0,
    @SerializedName("dt")
    val dt: Int = 0,
    @SerializedName("feels_like")
    val feelsLike: Double = 0.0,
    @SerializedName("humidity")
    val humidity: Int = 0,
    @SerializedName("pressure")
    val pressure: Int = 0,
    @SerializedName("sunrise")
    val sunrise: Int = 0,
    @SerializedName("sunset")
    val sunset: Int = 0,
    @SerializedName("temp")
    val temp: Double = 0.0,
    @SerializedName("uvi")
    val uvi: Float = 0.0f,
    @SerializedName("visibility")
    val visibility: Int = 0,
    @SerializedName("weather")
    val weather: List<Weather> = listOf(),
    @SerializedName("wind_deg")
    val windDeg: Int = 0,
    @SerializedName("wind_speed")
    val windSpeed: Double = 0.0
)