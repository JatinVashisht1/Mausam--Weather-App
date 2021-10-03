package com.example.mausamweatherapp.data.repository

import com.example.mausamweatherapp.data.remote.WeatherApi
import com.example.mausamweatherapp.data.remote.dto.response_by_lat_lon.LatLonResponseDto
import com.example.mausamweatherapp.data.remote.dto.stateResponseDto.ByStateResponseDto
import com.example.mausamweatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val api: WeatherApi)
    : WeatherRepository {

    override suspend fun getData(state: String): ByStateResponseDto {
        return api.getDataByState()
    }

    override suspend fun getDataByLanLon(lat: String, lon: String): LatLonResponseDto {
        return api.getDataByLanLon(lat, lon)
    }
}