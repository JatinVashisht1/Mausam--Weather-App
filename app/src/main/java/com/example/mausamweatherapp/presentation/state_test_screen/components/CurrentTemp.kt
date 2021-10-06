package com.example.mausamweatherapp.presentation.state_test_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Water
import androidx.compose.material.icons.filled.WbCloudy
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mausamweatherapp.domain.model.WeatherRequired

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
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 8.dp)) {
                if (news != null) {
                    Text(
                        text = (news.temp)
                            .toFloat()
                            .toString() + "°C",
                        style = MaterialTheme.typography.h4,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 14.dp),
                        textAlign = TextAlign.Start
                    )
                    when (news.weatherDesc) {
                        "Clear" -> {
                            Icon(imageVector = Icons.Default.WbSunny,
                                contentDescription = "Clear",
                                modifier = Modifier
                                    .size((MaterialTheme.typography.h3.fontSize).value.dp)
                                    .padding(start = 8.dp),
                                tint = Color.Yellow
                            )
                        }
                        "Rain" -> {
                            Icon(imageVector = Icons.Default.WbCloudy,
                                contentDescription = "Rain",
                                modifier = Modifier
                                    .size((MaterialTheme.typography.h3.fontSize).value.dp)
                                    .padding(start = 8.dp),
                                tint = Color.DarkGray
                            )
                        }
                        "Cloudy" -> {
                            Icon(imageVector = Icons.Default.WbCloudy,
                                contentDescription = "Cloud",
                                modifier = Modifier
                                    .size((MaterialTheme.typography.h3.fontSize).value.dp)
                                    .padding(start = 8.dp),
                                tint = Color.LightGray
                            )
                        }
                    }
                }
            }
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(start = 14.dp)){
                    if (news != null) {
                        Text(text = "Sky: " + news.weatherDesc,
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Bold)
                        Text(
                            text = "Feels Like " + String.format(
                                "%.2f",
                                (news.feelsLike)
                            ) + "°C",
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Bold,
                        )

                        Row {
                            Text(
                                text = "Humidity: "+ news.humidity,
                                style = MaterialTheme.typography.body1,
                                fontWeight = FontWeight.Bold
                            )

                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 1.dp, end = 24.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    if (news != null) {
                        Text(
                            text = "Location: "+ news.state,
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
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