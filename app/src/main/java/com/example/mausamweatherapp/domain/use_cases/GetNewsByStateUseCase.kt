package com.example.mausamweatherapp.domain.use_cases

import android.util.Log
import com.example.mausamweatherapp.common.Constants
import com.example.mausamweatherapp.common.Resource
import com.example.mausamweatherapp.data.remote.dto.state_response_dto.toWeatherRequired
import com.example.mausamweatherapp.domain.model.WeatherRequired
import com.example.mausamweatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetNewsByStateUseCase @Inject constructor(val api: WeatherRepository){
    operator fun invoke(state: String = "punjab,in") : Flow<Resource<WeatherRequired>> = flow {
        try {
            emit(Resource.Loading<WeatherRequired>())
            val news = api.getData()
//            emit(Resource.Success<StateWeather>(data = news.main.toStateWeather()))
            emit(Resource.Success<WeatherRequired>(data = news.toWeatherRequired()))

            Log.d(Constants.TAG, news.toString())
        }
        catch(e: IOException){
            emit(Resource.Error<WeatherRequired>(message = e.toString()))
        }
        catch(e: Exception){
            emit(Resource.Error<WeatherRequired>(message = e.toString()))
        }
    }
}