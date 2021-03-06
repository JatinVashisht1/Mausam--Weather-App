package com.example.mausamweatherapp.presentation.state_test_screen

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mausamweatherapp.common.Resource
import com.example.mausamweatherapp.domain.use_cases.days_forecast_use_case.GetNewsByForecastUseCase
import com.example.mausamweatherapp.domain.use_cases.hourly_forecast_use_case.GetHourlyForecastUseCase
import com.example.mausamweatherapp.domain.use_cases.news_by_lan_use_case.GetNewsByLanLon
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class StateViewModel @Inject constructor(
    @ApplicationContext
    context: Context,
    private val getNewsByLanLon: GetNewsByLanLon,
    private val getNewsByForecastUseCase: GetNewsByForecastUseCase,
    private val getHourlyForecastUseCase: GetHourlyForecastUseCase
//    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf<StateScreenState>(StateScreenState())
    val state: State<StateScreenState> = _state

    private val _daysForecast = mutableStateOf<ForecastScreenState>(ForecastScreenState())
    val daysForecast: State<ForecastScreenState> = _daysForecast

    private val _hourlyForecast = mutableStateOf<HourlyForecastScreenState>(
        HourlyForecastScreenState()
    )
    val hourlyForecast: State<HourlyForecastScreenState> = _hourlyForecast

    private val latitude = mutableStateOf("")
    private val longitude = mutableStateOf("")

    private val _refreshState = mutableStateOf(false)

    init {
        getLocation(context=context)
        getNews2()
        getWeatherForecast()
        getHourlyForecast()
    }

    private fun getLocation(context: Context){
        val locationManager: LocationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            /*
             Consider calling
                ActivityCompat#requestPermissions
             here to request the missing permissions, and then overriding
               public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                                      int[] grantResults)
             to handle the case where the user grants the permission. See the documentation
             for ActivityCompat#requestPermissions for more details.
                */
            return
        }

        val a = locationManager.getLastKnownLocation("gps")
        if (a != null) {
            latitude.value = a.latitude.toString()
            longitude.value = a.longitude.toString()
        }

    }

    private fun getNews2(){
        getNewsByLanLon(lat = latitude.value, lon = longitude.value).onEach { result->
            when(result){
                is Resource.Success -> _state.value = StateScreenState(news = result.data)
                is Resource.Loading -> _state.value = StateScreenState(isLoading = true)
                is Resource.Error -> _state.value = StateScreenState(error = result.message!!)
            }
        }.launchIn(viewModelScope)
    }

    private fun getWeatherForecast(){
        getNewsByForecastUseCase(lat = latitude.value, lon = longitude.value).onEach { result->
            when(result){
                is Resource.Loading -> _daysForecast.value = ForecastScreenState(isLoading = true)
                is Resource.Success -> _daysForecast.value = ForecastScreenState(data = result.data)
                is Resource.Error -> _daysForecast.value = ForecastScreenState(error = result.message!!)
            }
        }.launchIn(viewModelScope)
    }

    private fun getHourlyForecast(){
        getHourlyForecastUseCase(lat = latitude.value, lon = longitude.value).onEach { result->
            when(result){
                is Resource.Loading -> _hourlyForecast.value = HourlyForecastScreenState(isLoading = true)
                is Resource.Success -> _hourlyForecast.value = HourlyForecastScreenState(data = result.data)
                is Resource.Error -> _hourlyForecast.value = HourlyForecastScreenState(error = result.message!!)
            }
        }.launchIn(viewModelScope)
    }

//    @RequiresApi(Build.VERSION_CODES.R)



}