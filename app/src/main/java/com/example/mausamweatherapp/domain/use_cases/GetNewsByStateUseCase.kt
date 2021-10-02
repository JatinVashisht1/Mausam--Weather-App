package com.example.mausamweatherapp.domain.use_cases

import android.util.Log
import com.example.mausamweatherapp.common.Constants
import com.example.mausamweatherapp.common.Resource
import com.example.mausamweatherapp.data.remote.WeatherApi
import com.example.mausamweatherapp.data.remote.dto.stateResponseDto.toStateWeather
import com.example.mausamweatherapp.domain.model.StateWeather
import com.example.mausamweatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetNewsByStateUseCase @Inject constructor(val api: WeatherRepository){
    operator fun invoke(state: String = "punjab,in") : Flow<Resource<StateWeather>> = flow {
        try {
            emit(Resource.Loading<StateWeather>())
            val news = api.getData()
            emit(Resource.Success<StateWeather>(data = news.main.toStateWeather()))
            Log.d(Constants.TAG, news.toString())
        }
        catch(e: IOException){
            emit(Resource.Error<StateWeather>(message = e.toString()))
        }
        catch(e: Exception){
            emit(Resource.Error<StateWeather>(message = e.toString()))
        }
    }
}