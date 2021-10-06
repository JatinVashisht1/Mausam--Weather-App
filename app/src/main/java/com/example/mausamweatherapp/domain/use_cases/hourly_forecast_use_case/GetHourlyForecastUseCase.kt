package com.example.mausamweatherapp.domain.use_cases.hourly_forecast_use_case

import android.util.Log
import com.example.mausamweatherapp.common.Constants
import com.example.mausamweatherapp.common.Resource
import com.example.mausamweatherapp.data.remote.dto.days_forecast_response_dto.toDaysForecast
import com.example.mausamweatherapp.data.remote.dto.hourly_forecast_dto.toHourlyForecastList
import com.example.mausamweatherapp.data.remote.dto.response_by_lat_lon.toWeatherRequired
import com.example.mausamweatherapp.domain.model.*
import com.example.mausamweatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetHourlyForecastUseCase@Inject constructor(val api: WeatherRepository){
    operator fun invoke(lat: String, lon: String) : Flow<Resource<HourlyForecastList>> = flow {
        try {
            emit(Resource.Loading<HourlyForecastList>())
            val news = api.getHourlyForecast(lat = lat, long = lon)
//            emit(Resource.Success<StateWeather>(data = news.main.toStateWeather()))
            emit(Resource.Success<HourlyForecastList>(data = news.toHourlyForecastList()))

            Log.d(Constants.TAG, news.toString())
        }
        catch(e: IOException){
            emit(Resource.Error<HourlyForecastList>(message = e.toString()))
        }
        catch(e: Exception){
            emit(Resource.Error<HourlyForecastList>(message = e.toString()))
        }
    }
}