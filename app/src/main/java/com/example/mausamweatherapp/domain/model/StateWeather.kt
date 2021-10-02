package com.example.mausamweatherapp.domain.model

data class StateWeather(
    val feelsLike: Double,
    val temp: Double,
    val pressure: Int,
    val tempMax: Double,
    val tempMin: Double,
    val humidity: Int
)