package com.example.mausamweatherapp.presentation.state_test_screen

import com.example.mausamweatherapp.domain.model.StateWeather
import com.example.mausamweatherapp.domain.model.WeatherRequired

data class StateScreenState(
    val isLoading: Boolean = false,
    val news: WeatherRequired?=null,
    val error: String = ""
)
