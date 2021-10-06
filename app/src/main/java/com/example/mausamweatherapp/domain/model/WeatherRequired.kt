package com.example.mausamweatherapp.domain.model

data class WeatherRequired(
    val feelsLike: Double,
    val temp: Double,
    val pressure: Int,
    val tempMax: Double,
    val tempMin: Double,
    val humidity: Int,
    val weatherDesc: String,
    val country: String,
    val state: String,
    val windSpeed: Double,
    val sunRise: Int,
    val sunSet: Int
)