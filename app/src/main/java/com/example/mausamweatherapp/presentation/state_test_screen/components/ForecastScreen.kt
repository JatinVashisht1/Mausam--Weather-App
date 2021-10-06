package com.example.mausamweatherapp.presentation.state_test_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WbCloudy
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mausamweatherapp.domain.model.DailyForecast
import com.example.mausamweatherapp.presentation.state_test_screen.ForecastScreenState
import java.text.DateFormat
import java.text.SimpleDateFormat

@Composable
fun ForecastScreen(state: ForecastScreenState) {
    val list = state.data?.dailyList?.subList(1, 8)
    Column {
        if(state.error.isNotBlank()){
            Text(text = state.error.toString())
        }

    }
    if (state.data != null) {
        Card(
            modifier = Modifier
                .padding(14.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Column {
                Text(
                    text = "Days Forecast",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(8.dp)
                )
                if (list != null) {
                    ForecastItems(weather = list)
                }
            }
        }
    }
}

    @Composable
    fun ForecastItems(weather: List<DailyForecast>) {
        LazyRow() {
            items(weather) { item ->
                ForecastItem(weather = item)
            }
        }
    }

    @Composable
    fun ForecastItem(weather: DailyForecast) {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .padding(8.dp)
        ) {

            Row{
            Column() {
                val formatter: DateFormat = SimpleDateFormat("dd/MM/yyyy")


                Text(
                    text = String.format("%.2f", weather.feelsLike).toString(),
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = weather.weather,
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = formatter.format((weather.dateMilli.toLong())*1000).toString(),
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.SemiBold
                )
            }
                when (weather.weather) {
                    "Clear" -> {
                        Icon(imageVector = Icons.Default.WbSunny,
                            contentDescription = "Clear",
                            modifier = Modifier
                                .size((MaterialTheme.typography.h6.fontSize).value.dp + MaterialTheme.typography.body2.fontSize.value.dp)
                                .padding(end = 12.dp),
                            tint = Color.Yellow
                        )
                    }
                    "Rain" -> {
                        Icon(imageVector = Icons.Default.WbCloudy,
                            contentDescription = "Rain",
                            modifier = Modifier
                                .size((MaterialTheme.typography.h6.fontSize).value.dp + MaterialTheme.typography.body2.fontSize.value.dp)
                                .padding(end = 12.dp),
                            tint = Color.DarkGray
                        )
                    }
                    "Clouds" -> {
                        Icon(imageVector = Icons.Default.WbCloudy,
                            contentDescription = "Cloud",
                            modifier = Modifier
                                .size((MaterialTheme.typography.h6.fontSize).value.dp + MaterialTheme.typography.body2.fontSize.value.dp)
                                .padding(end = 12.dp),
                            tint = Color.LightGray
                        )
                    }
                }
        }
    }
}

