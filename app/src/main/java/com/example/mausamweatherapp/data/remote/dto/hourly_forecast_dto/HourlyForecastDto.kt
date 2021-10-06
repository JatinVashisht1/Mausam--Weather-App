package com.example.mausamweatherapp.data.remote.dto.hourly_forecast_dto


import com.example.mausamweatherapp.domain.model.HourlyForecastList
import com.google.gson.annotations.SerializedName

data class HourlyForecastDto(
    @SerializedName("current")
    val current: Current = Current(),
    @SerializedName("hourly")
    val hourly: List<Hourly> = listOf(),
    @SerializedName("lat")
    val lat: Double = 0.0,
    @SerializedName("lon")
    val lon: Double = 0.0,
    @SerializedName("timezone")
    val timezone: String = "",
    @SerializedName("timezone_offset")
    val timezoneOffset: Int = 0
)

fun HourlyForecastDto.toHourlyForecastList() : HourlyForecastList{
    return HourlyForecastList(
        hourlyForecastList = hourly.map { it.toHourlyForecast() }
    )
}