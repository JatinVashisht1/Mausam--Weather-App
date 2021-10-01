package com.example.mausamweatherapp.domain.repository

import com.example.mausamweatherapp.data.remote.dto.stateResponseDto.ByStateResponseDto

interface WeatherApi {
    suspend fun getData() : List<ByStateResponseDto>
}