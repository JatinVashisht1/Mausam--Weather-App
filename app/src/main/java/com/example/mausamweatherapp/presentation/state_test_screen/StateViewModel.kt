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
import com.example.mausamweatherapp.domain.use_cases.GetNewsByStateUseCase
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
    private val getNewsByStateUseCase: GetNewsByStateUseCase,
    private val getNewsByLanLon: GetNewsByLanLon
//    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf<StateScreenState>(StateScreenState())
    val state: State<StateScreenState> = _state

    private val latitude = mutableStateOf("")
    private val longitude = mutableStateOf("")

    init {
        getLocation(context=context)
        getNews2()
    }

    fun getLocation(context: Context){
        val locationManager: LocationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }

        val a = locationManager.getLastKnownLocation("gps")
        if (a != null) {
            latitude.value = a.latitude.toString()
            longitude.value = a.longitude.toString()
        }

    }

    fun getNews(state: String = "punjab,in"){
        getNewsByStateUseCase(state = state).onEach {result->
            when(result){
                is Resource.Success ->{
                    _state.value = StateScreenState(news = result.data)
                }
                is Resource.Loading ->{
                    _state.value = StateScreenState(isLoading = true)
                }
                is Resource.Error ->{
                    _state.value = StateScreenState(error = result.message!!)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getNews2(){
        getNewsByLanLon(lat = latitude.value, lon = longitude.value).onEach { result->
            when(result){
                is Resource.Success ->{
                    _state.value = StateScreenState(news = result.data)
                }
                is Resource.Loading ->{
                    _state.value = StateScreenState(isLoading = true)
                }
                is Resource.Error ->{
                    _state.value = StateScreenState(error = result.message!!)
                }
            }
        }.launchIn(viewModelScope)
    }

//    @RequiresApi(Build.VERSION_CODES.R)

}