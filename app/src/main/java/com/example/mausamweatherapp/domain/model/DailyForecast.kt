package com.example.mausamweatherapp.domain.model

data class DailyForecast (
    val feelsLike: Float,
    val pressure: Int,
    val dateMilli: Int,
    val humidity: Int,
    val rain: Double,
    val weather: String
)

/*
val clouds: Int = 0,
val dewPoint: Double = 0.0,
val dt: Int = 0,
val feelsLike: FeelsLike = FeelsLike(),
val humidity: Int = 0,
val moonPhase: Double = 0.0,
val moonrise: Int = 0,
val moonset: Int = 0,
val pop: Int = 0,
val pressure: Int = 0,
val rain: Double = 0.0,
val sunrise: Int = 0,
val sunset: Int = 0,
val temp: Temp = Temp(),
val uvi: Double = 0.0,
val weather: List<WeatherX> = listOf(),
val windDeg: Int = 0,
val windGust: Double = 0.0,
val windSpeed: Double = 0.0
 */