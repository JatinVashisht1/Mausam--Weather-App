package com.example.mausamweatherapp.presentation.state_test_screen

import com.example.mausamweatherapp.domain.model.DailyForecast
import com.example.mausamweatherapp.domain.model.DaysForecast

data class ForecastScreenState (
    val isLoading: Boolean= false,
    val data: DaysForecast? = null,
    val error: String = ""
)