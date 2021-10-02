package com.example.mausamweatherapp.data.repository

import com.example.mausamweatherapp.data.remote.WeatherApi
import com.example.mausamweatherapp.data.remote.dto.stateResponseDto.ByStateResponseDto
import com.example.mausamweatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherApiImpl @Inject constructor(private val api: WeatherApi)
    : WeatherRepository {

    override suspend fun getData(state: String): ByStateResponseDto {
        return api.getDataByState()
    }
}