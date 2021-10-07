package com.example.mausamweatherapp.presentation.state_test_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mausamweatherapp.domain.model.WeatherRequired
import java.text.DateFormat
import java.text.SimpleDateFormat
import com.example.mausamweatherapp.R
import com.example.mausamweatherapp.presentation.ui.theme.YellowLight

@Composable
fun DetailTemp(news: WeatherRequired?) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .shadow(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(6.dp)
            ,verticalArrangement = Arrangement.SpaceEvenly
        ) {
            if (news != null) {
                val formatter: DateFormat = SimpleDateFormat("hh:mm aa")
                SimpleDateFormat()

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(painter = painterResource(id = R.drawable.air_pressure),
                            contentDescription = "air pressure",
                            modifier = Modifier
                                .size(MaterialTheme.typography.h4.fontSize.value.dp)
                                .padding(end = 4.dp)

                        )
                        Text(
                            text = "Pressure: ",
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.SemiBold,
                        )
                    }
                    Text(
                        text = news.pressure.toString(),
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.SemiBold,
//                        modifier = Modifier.align(Alignment.End)
                    )
                }

                Spacer(modifier = Modifier.padding(4.dp))
                Divider(color = YellowLight)
                Spacer(modifier = Modifier.padding(4.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.wind_speed),
                            contentDescription = "wind speed",
                            modifier = Modifier
                                .size(MaterialTheme.typography.h4.fontSize.value.dp)
                                .padding(end = 4.dp)
                        )
                        Text(
                            text = "Wind speed: ",
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Text(
                        text = news.windSpeed.toString() + " metre/sec",
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.SemiBold,
                    )
                }

                Spacer(modifier = Modifier.padding(4.dp))
                Divider(color = YellowLight)
                Spacer(modifier = Modifier.padding(4.dp))


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.sunrise),
                            contentDescription = "sunrise",
                            modifier = Modifier
                                .size(MaterialTheme.typography.h4.fontSize.value.dp)
                                .padding(end = 4.dp)                        )
                        Text(
                            text = "Sunrise: ",
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Text(
                        text = formatter.format((news.sunRise).toLong() * 1000),
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.padding(4.dp))
                Divider(color = YellowLight)
                Spacer(modifier = Modifier.padding(4.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.sunset),
                            contentDescription = "sunset",
                            modifier = Modifier
                                .size(MaterialTheme.typography.h4.fontSize.value.dp)
                                .padding(end = 4.dp)                        )
                        Text(
                            text = "Sunset: ",
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Text(
                        text = formatter.format((news.sunSet).toLong() * 1000),
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.SemiBold
                    )

                }
            }
        }
    }
}