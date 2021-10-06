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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mausamweatherapp.domain.model.StateWeather
import com.example.mausamweatherapp.domain.model.WeatherRequired
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun DetailTemp(news: WeatherRequired?) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier.padding(6.dp)
        ) {
            if (news != null) {
                val formatter: DateFormat = SimpleDateFormat("hh:mm aa")
                SimpleDateFormat()
//                Text(text = "Humidity: " + news.humidity.toString() + "%",
//                    style = MaterialTheme.typography.h6,
//                    fontWeight = FontWeight.SemiBold)
                Text(text = "Pressure: " + news.pressure.toString(),
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.SemiBold)
                Text(text = "Wind speed: " + news.windSpeed.toString() + " metre/sec",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.SemiBold)
                Text(text = "Sunrise: " + formatter.format((news.sunRise).toLong()*1000),
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.SemiBold)
                Text(text = "Sunset: " + formatter.format((news.sunSet).toLong()*1000),
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.SemiBold)
            }
        }
    }
}