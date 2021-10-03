package com.example.mausamweatherapp.presentation.state_test_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WbCloudy
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mausamweatherapp.domain.model.StateWeather
import com.example.mausamweatherapp.domain.model.WeatherRequired
import java.text.DateFormat
import java.time.Instant
import java.time.LocalTime
import java.util.*
import java.util.Calendar.AM_PM
import kotlin.time.ExperimentalTime

//@ExperimentalTime
@Composable
fun CurrentTemp(modifier: Modifier = Modifier, news: WeatherRequired?) {
    Box(
        modifier = Modifier.fillMaxWidth()
//            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
//            .padding(8.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {

                if (news != null) {
                    Text(
                        text = (news.temp - 273.15)
                            .toFloat()
                            .toString() + "°C",
                        style = MaterialTheme.typography.h3,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 14.dp),
                        textAlign = TextAlign.Start
                    )


                }
            }
        }
    }
}


//
//val now = Calendar.getInstance()
//if (now[AM_PM] == Calendar.AM) {
//    // AM
//    Text(text = "AM")
//} else {
//    // PM
//    Text(text = "PM")
//}