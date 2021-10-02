package com.example.mausamweatherapp.data.remote

import com.example.mausamweatherapp.data.remote.dto.stateResponseDto.ByStateResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    suspend fun getDataByState(
        @Query("q") q: String = "punjab,in",
        @Query("appid") apiId: String = "f4e79c82cca98f2d8e71d1bdb8354c31"
    ) : ByStateResponseDto
}