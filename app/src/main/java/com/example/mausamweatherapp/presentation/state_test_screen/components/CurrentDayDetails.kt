package com.example.mausamweatherapp.presentation.state_test_screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mausamweatherapp.presentation.state_test_screen.StateScreenState

@Composable
fun CurrentDayDetails(weather: StateScreenState) {
    Box(modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp)
        ) {
            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = weather.news?.humidity.toString(), style = MaterialTheme.typography.body2)
            }
        }
    }
}