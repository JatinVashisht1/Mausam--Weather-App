package com.example.mausamweatherapp.data.remote

import com.example.mausamweatherapp.data.remote.dto.days_forecast_response_dto.DaysForecastDto
import com.example.mausamweatherapp.data.remote.dto.hourly_forecast_dto.HourlyForecastDto
import com.example.mausamweatherapp.data.remote.dto.response_by_lat_lon.LatLonResponseDto
import com.example.mausamweatherapp.data.remote.dto.state_response_dto.ByStateResponseDto
import retrofit2.http.GET
import retrofit2.http.Query
// http://api.openweathermap.org/data/2.5/onecall?lat=30&lon=75&exclude=hourly,minutely&appid=f4e79c82cca98f2d8e71d1bdb8354c31
interface WeatherApi {
    @GET("weather")
    suspend fun getDataByState(
        @Query("q") q: String = "ropar,punjab,in",
        @Query("appid") apiId: String = "c8ba74620ece46198c251aef66cc6259",
        @Query("units") units: String = "metric"
    ) : ByStateResponseDto

    @GET("weather")
    suspend fun getDataByLanLon(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") apiId: String = "c8ba74620ece46198c251aef66cc6259",
        @Query("units") units: String = "metric"
    ) : LatLonResponseDto

    @GET("onecall")
    suspend fun getDaysForecast(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("exclude") exclude: String = "hourly, minutely",
        @Query("appid") apiId: String = "c8ba74620ece46198c251aef66cc6259",
        @Query("units") units: String = "metric",
    ) : DaysForecastDto

    @GET("onecall")
    suspend fun getHourlyForecast(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("exclude") exclude: String = "daily, minutely",
        @Query("appid") apiId: String = "c8ba74620ece46198c251aef66cc6259",
        @Query("units") units: String = "metric",
    ) : HourlyForecastDto
}