package com.example.mausamweatherapp.domain.repository

import com.example.mausamweatherapp.data.remote.dto.stateResponseDto.ByStateResponseDto

interface WeatherRepository {
    suspend fun getData(state: String="punjab,in") : ByStateResponseDto
}