package com.example.mausamweatherapp.presentation.state_test_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mausamweatherapp.presentation.state_test_screen.components.CurrentTemp

@Composable
fun StateWeatherScreen(
    viewModel: StateViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Column(modifier = Modifier.fillMaxSize()) {
        CurrentTemp(news = state.news)
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

//            state.news?.toString()?.let { Text(it, style = MaterialTheme.typography.body1) }

                if (state.error.isNotBlank()) {
                    Text(text = state.error.toString(), style = MaterialTheme.typography.body1)
                }
            }
        }

    }
}