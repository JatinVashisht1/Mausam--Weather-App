package com.example.mausamweatherapp.domain.repository

import com.example.mausamweatherapp.data.remote.dto.days_forecast_response_dto.DaysForecastDto
import com.example.mausamweatherapp.data.remote.dto.hourly_forecast_dto.HourlyForecastDto
import com.example.mausamweatherapp.data.remote.dto.response_by_lat_lon.LatLonResponseDto
import com.example.mausamweatherapp.data.remote.dto.state_response_dto.ByStateResponseDto

interface WeatherRepository {
    suspend fun getData(state: String="punjab,in") : ByStateResponseDto
    suspend fun getDataByLanLon(lat: String, lon: String) : LatLonResponseDto
    suspend fun getDataByForecast(lat: String, lon: String) : DaysForecastDto
    suspend fun getHourlyForecast(lat: String, long: String) : HourlyForecastDto
}