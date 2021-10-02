package com.example.mausamweatherapp.presentation.state_test_screen

import com.example.mausamweatherapp.domain.model.StateWeather

data class StateScreenState(
    val isLoading: Boolean = false,
    val news: StateWeather?=null,
    val error: String = ""
)
