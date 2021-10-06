package com.example.mausamweatherapp.presentation.state_test_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WbCloudy
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mausamweatherapp.domain.model.HourlyForecast
import com.example.mausamweatherapp.presentation.state_test_screen.HourlyForecastScreenState
import com.example.mausamweatherapp.presentation.state_test_screen.StateViewModel
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun HourlyForecast(
    hourlyState: HourlyForecastScreenState
) {
//    val list = hourlyState.data?.copy(
//        hourlyForecastList = hourlyState.data.hourlyForecastList.subList(0, 24)
//    )
    if (hourlyState.error.isNotBlank()) {
        Text(text = hourlyState.error, style = MaterialTheme.typography.h6, color = Color.Red)
    }
    Card( modifier = Modifier
        .padding(14.dp)
        .fillMaxWidth()
        .wrapContentHeight()) {
        Column {
            Text(text = "Hourly Forecast",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(8.dp))
            hourlyState.data?.let {
                HourForecastList(hourlyState.data.hourlyForecastList)
            }
        }
    }
}

@Composable
fun HourForecastList(data: List<HourlyForecast>) {
    LazyRow {
        items(data){item->
            HourForecastListItem(item)
        }
    }
}

@Composable
fun HourForecastListItem(item: HourlyForecast) {
    Row(
        modifier = Modifier
            .padding(8.dp)
) {
        Column {
            val formatter: DateFormat = SimpleDateFormat("hh:mm aa")

            val date = formatter.format((item.date).toLong()*1000)
                Text(
                text = String.format("%.2f", item.temp),
                style = MaterialTheme.typography.h6
            )
            Text(
                text = item.sky.toString(),
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = date.toString(),
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.SemiBold
            )
        }
        when (item.sky) {
            "Clear" -> {
                Icon(imageVector = Icons.Default.WbSunny,
                    contentDescription = "Clear",
                    modifier = Modifier
                        .size((MaterialTheme.typography.h6.fontSize).value.dp + MaterialTheme.typography.body2.fontSize.value.dp)
                        .padding(start = 8.dp, end = 4.dp),
                    tint = Color.Yellow
                )
            }
            "Rain" -> {
                Icon(imageVector = Icons.Default.WbCloudy,
                    contentDescription = "Rain",
                    modifier = Modifier
                        .size((MaterialTheme.typography.h6.fontSize).value.dp + MaterialTheme.typography.body2.fontSize.value.dp)
                        .padding(start = 8.dp, end = 4.dp),
                    tint = Color.DarkGray
                )
            }
            "Clouds" -> {
                Icon(imageVector = Icons.Default.WbCloudy,
                    contentDescription = "Cloud",
                    modifier = Modifier
                        .size((MaterialTheme.typography.h6.fontSize).value.dp + MaterialTheme.typography.body2.fontSize.value.dp)
                        .padding(start = 8.dp, end = 4.dp),
                    tint = Color.LightGray
                )
            }
        }
    }
}
