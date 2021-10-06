package com.example.mausamweatherapp.data.repository

import com.example.mausamweatherapp.data.remote.WeatherApi
import com.example.mausamweatherapp.data.remote.dto.days_forecast_response_dto.DaysForecastDto
import com.example.mausamweatherapp.data.remote.dto.hourly_forecast_dto.HourlyForecastDto
import com.example.mausamweatherapp.data.remote.dto.response_by_lat_lon.LatLonResponseDto
import com.example.mausamweatherapp.data.remote.dto.state_response_dto.ByStateResponseDto
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

    override suspend fun getDataByForecast(lat: String, lon: String): DaysForecastDto {
        return api.getDaysForecast(lat = lat, lon = lon)
    }

    override suspend fun getHourlyForecast(lat: String, long: String): HourlyForecastDto {
       return api.getHourlyForecast(lat = lat, lon = long)
    }
}