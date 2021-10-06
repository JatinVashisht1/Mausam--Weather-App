package com.example.mausamweatherapp.presentation.state_test_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mausamweatherapp.presentation.state_test_screen.components.*

@Composable
fun StateWeatherScreen(
    viewModel: StateViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val daysForecast = viewModel.daysForecast.value
    val scrollableState = rememberScrollState()
    val hourlyState = viewModel.hourlyForecast.value

    Column(modifier = Modifier
        .fillMaxSize()

    ) {

        LazyColumn{
            item(1){
                CurrentTemp(news = state.news)
                ForecastScreen(daysForecast)
                HourlyForecast(hourlyState = hourlyState)
                DetailTemp(news = state.news)
            }
        }


        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (state.isLoading) {
                CircularProgressIndicator()
            }
            Column(
                modifier = Modifier.fillMaxHeight(0.25f)
            ) {

                if (state.error.isNotBlank()) {
                    Text(text = state.error.toString(), style = MaterialTheme.typography.body1)
                }
            }
        }
    }
}

