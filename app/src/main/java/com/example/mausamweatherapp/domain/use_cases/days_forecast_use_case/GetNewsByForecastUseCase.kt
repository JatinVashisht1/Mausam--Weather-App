package com.example.mausamweatherapp.domain.use_cases.days_forecast_use_case

import android.util.Log
import com.example.mausamweatherapp.common.Constants
import com.example.mausamweatherapp.common.Resource
import com.example.mausamweatherapp.data.remote.dto.days_forecast_response_dto.toDaysForecast
import com.example.mausamweatherapp.data.remote.dto.response_by_lat_lon.toWeatherRequired
import com.example.mausamweatherapp.domain.model.DailyForecast
import com.example.mausamweatherapp.domain.model.DaysForecast
import com.example.mausamweatherapp.domain.model.WeatherRequired
import com.example.mausamweatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetNewsByForecastUseCase@Inject constructor(val api: WeatherRepository){
    operator fun invoke(lat: String, lon: String) : Flow<Resource<DaysForecast>> = flow {
        try {
            emit(Resource.Loading<DaysForecast>())
            val news = api.getDataByForecast(lat = lat, lon = lon)
//            emit(Resource.Success<StateWeather>(data = news.main.toStateWeather()))
            emit(Resource.Success<DaysForecast>(data = news.toDaysForecast()))

            Log.d(Constants.TAG, news.toString())
        }
        catch(e: IOException){
            emit(Resource.Error<DaysForecast>(message = e.toString()))
        }
        catch(e: Exception){
            emit(Resource.Error<DaysForecast>(message = e.toString()))
        }
    }
}