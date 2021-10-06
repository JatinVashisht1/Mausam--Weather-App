package com.example.mausamweatherapp.data.remote.dto.days_forecast_response_dto


import com.example.mausamweatherapp.domain.model.DailyForecast
import com.google.gson.annotations.SerializedName

data class Daily(
    @SerializedName("clouds")
    val clouds: Float = 0.0f,
    @SerializedName("dew_point")
    val dewPoint: Double = 0.0,
    @SerializedName("dt")
    val dt: Int = 0,
    @SerializedName("feels_like")
    val feelsLike: FeelsLike = FeelsLike(),
    @SerializedName("humidity")
    val humidity: Float = 0.0f,
    @SerializedName("moon_phase")
    val moonPhase: Double = 0.0,
    @SerializedName("moonrise")
    val moonrise: Int = 0,
    @SerializedName("moonset")
    val moonset: Int = 0,
    @SerializedName("pop")
    val pop: Float = 0.0f,
    @SerializedName("pressure")
    val pressure: Int = 0,
    @SerializedName("rain")
    val rain: Double = 0.0,
    @SerializedName("sunrise")
    val sunrise: Int = 0,
    @SerializedName("sunset")
    val sunset: Int = 0,
    @SerializedName("temp")
    val temp: Temp = Temp(),
    @SerializedName("uvi")
    val uvi: Double = 0.0,
    @SerializedName("weather")
    val weather: List<WeatherX> = listOf(),
    @SerializedName("wind_deg")
    val windDeg: Int = 0,
    @SerializedName("wind_gust")
    val windGust: Double = 0.0,
    @SerializedName("wind_speed")
    val windSpeed: Double = 0.0
)

fun Daily.toDailyForecast() : DailyForecast{
    return DailyForecast(
        feelsLike = ((feelsLike.day + feelsLike.eve + feelsLike.morn + feelsLike.night)/4f).toFloat(),
        pressure = pressure,
        dateMilli = dt,
        humidity = humidity.toFloat(),
        rain = rain,
        weather = weather.first().main
    )
}
