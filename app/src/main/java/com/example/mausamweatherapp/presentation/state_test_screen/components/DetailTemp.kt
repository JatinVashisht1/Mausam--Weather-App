package com.example.mausamweatherapp.presentation.state_test_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mausamweatherapp.domain.model.StateWeather
import com.example.mausamweatherapp.domain.model.WeatherRequired

@Composable
fun DetailTemp(news: WeatherRequired?) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier.padding(4.dp)
        ) {
            if (news != null) {
                Text(
                    text = "Sky: " + news.weatherDesc,
                    style = MaterialTheme.typography.h5
                )
                Text(text = "Feels Like: " + (news.feelsLike - 273.15)
                    .toFloat()
                    .toString(),
                    style = MaterialTheme.typography.h5)
                Text(text = "MaxTemp: " + (news.tempMax - 273.15).toFloat().toString(),
                    style = MaterialTheme.typography.h5)
                Text(text = "MinTemp: " + (news.tempMin - 273.15).toFloat().toString(),
                    style = MaterialTheme.typography.h5)
                Text(text = "Humidity: " + news.humidity.toString() + "%",
                    style = MaterialTheme.typography.h5)
                Text(text = "Pressure: " + news.pressure.toString(),
                    style = MaterialTheme.typography.h5)

            }
        }
    }
}