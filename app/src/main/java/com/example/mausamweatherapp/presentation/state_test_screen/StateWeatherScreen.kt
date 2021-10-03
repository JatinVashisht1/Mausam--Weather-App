package com.example.mausamweatherapp.presentation.state_test_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mausamweatherapp.MainActivity
import com.example.mausamweatherapp.presentation.state_test_screen.components.CurrentTemp
import com.example.mausamweatherapp.presentation.state_test_screen.components.DescriptionScreen
import com.example.mausamweatherapp.presentation.state_test_screen.components.DetailTemp

@Composable
fun StateWeatherScreen(

    viewModel: StateViewModel = hiltViewModel(),
    context: MainActivity
) {
    val state = viewModel.state.value
    Column(modifier = Modifier.fillMaxSize()) {
        CurrentTemp(news = state.news)

        DetailTemp(news = state.news)

        DescriptionScreen(weather = state.news, context = context)

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