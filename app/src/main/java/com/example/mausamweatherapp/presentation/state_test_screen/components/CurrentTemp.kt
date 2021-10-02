package com.example.mausamweatherapp.presentation.state_test_screen.components

import android.os.SystemClock
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mausamweatherapp.domain.model.StateWeather
import java.time.Clock
import java.time.LocalTime
import java.util.*

@Composable
fun CurrentTemp(modifier: Modifier = Modifier, news: StateWeather?) {
    Box(
        modifier = Modifier.fillMaxWidth()
//            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
//            .padding(8.dp)
        ) {
            Row {

                if (news != null) Text(
                    text = (news.temp - 273.15)
                        .toInt()
                        .toString() + "°C",
                    style = MaterialTheme.typography.h3,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 12.dp),
                    textAlign = TextAlign.Start
                )

            }
                Text(Calendar.getInstance().time.hours.toString())

        }
    }
}