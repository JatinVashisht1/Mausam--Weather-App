package com.example.mausamweatherapp.data.remote.dto.state_response_dto


import com.example.mausamweatherapp.domain.model.StateWeather
import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("feels_like")
    val feelsLike: Double = 0.0,
    @SerializedName("grnd_level")
    val grndLevel: Int = 0,
    @SerializedName("humidity")
    val humidity: Int = 0,
    @SerializedName("pressure")
    val pressure: Int = 0,
    @SerializedName("sea_level")
    val seaLevel: Int = 0,
    @SerializedName("temp")
    val temp: Double = 0.0,
    @SerializedName("temp_max")
    val tempMax: Double = 0.0,
    @SerializedName("temp_min")
    val tempMin: Double = 0.0
)

fun Main.toStateWeather() : StateWeather{
    return StateWeather(
        feelsLike = feelsLike,
        temp = temp,
        pressure = pressure,
        tempMax = tempMax,
        tempMin = tempMin,
        humidity = humidity
    )
}