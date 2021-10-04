package com.example.mausamweatherapp.domain.repository

import com.example.mausamweatherapp.data.remote.dto.response_by_lat_lon.LatLonResponseDto
import com.example.mausamweatherapp.data.remote.dto.state_response_dto.ByStateResponseDto

interface WeatherRepository {
    suspend fun getData(state: String="punjab,in") : ByStateResponseDto
    suspend fun getDataByLanLon(lat: String, lon: String) : LatLonResponseDto
}