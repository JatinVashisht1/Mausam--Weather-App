package com.example.mausamweatherapp.data.remote.dto.days_forecast_response_dto


import com.example.mausamweatherapp.domain.model.DaysForecast
import com.google.gson.annotations.SerializedName

data class DaysForecastDto(
    @SerializedName("current")
    val current: Current = Current(),
    @SerializedName("daily")
    val daily: List<Daily> = listOf(),
    @SerializedName("lat")
    val lat: Double = 0.0,
    @SerializedName("lon")
    val lon: Double = 0.0,
    @SerializedName("timezone")
    val timezone: String = "",
    @SerializedName("timezone_offset")
    val timezoneOffset: Int = 0
)

fun DaysForecastDto.toDaysForecast() : DaysForecast{
    return DaysForecast(
        dailyList = daily.map {day->
            day.toDailyForecast()
        }
    )
}