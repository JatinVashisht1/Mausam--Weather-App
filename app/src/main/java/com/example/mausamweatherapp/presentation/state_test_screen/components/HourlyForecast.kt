package com.example.mausamweatherapp.presentation.state_test_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mausamweatherapp.R
import com.example.mausamweatherapp.domain.model.HourlyForecast
import com.example.mausamweatherapp.presentation.state_test_screen.HourlyForecastScreenState
import java.text.DateFormat
import java.text.SimpleDateFormat

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
        .wrapContentHeight()
        .shadow(8.dp)
    ) {
        Column {
            Text(text = "Hourly Forecast",
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(8.dp)
                    .padding(start = 11.dp)
            )
            hourlyState.data?.let {
                HourForecastList(hourlyState.data.hourlyForecastList)
            }
        }
    }
}

@Composable
fun HourForecastList(data: List<HourlyForecast>) {
    LazyRow (modifier = Modifier.padding(start = 12.dp, end = 12.dp)){
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
                Image(
                    painter = painterResource(id = R.drawable.sun),
                    contentDescription = "Clear",
                    modifier = Modifier
                        .size((MaterialTheme.typography.h6.fontSize).value.dp + MaterialTheme.typography.body2.fontSize.value.dp)
                        .padding(end = 12.dp),
//                    tint = Color(0xffEBB307)
                )
            }
            "Rain" -> {
                Image(painter = painterResource(id = R.drawable.rain), contentDescription = "rain",
                    modifier = Modifier
                        .size((MaterialTheme.typography.h6.fontSize).value.dp + MaterialTheme.typography.body2.fontSize.value.dp)
                        .padding(end = 12.dp))
            }
            "Clouds" -> {
                Image(painter = painterResource(id = R.drawable.cloudy_day),
                    contentDescription = "Cloud",
                    modifier = Modifier
                        .size((MaterialTheme.typography.h6.fontSize).value.dp + MaterialTheme.typography.body2.fontSize.value.dp)
                        .padding(end = 12.dp),
//                            tint = Color.LightGray
                )
            }
        }
    }
}
