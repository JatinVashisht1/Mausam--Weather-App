package com.example.mausamweatherapp.presentation.state_test_screen

import com.example.mausamweatherapp.domain.model.DailyForecast
import com.example.mausamweatherapp.domain.model.DaysForecast
import com.example.mausamweatherapp.domain.model.HourlyForecastList

data class HourlyForecastScreenState (
    val isLoading: Boolean= false,
    val data: HourlyForecastList? = null,
    val error: String = ""
)