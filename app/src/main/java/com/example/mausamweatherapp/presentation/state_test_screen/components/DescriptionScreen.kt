package com.example.mausamweatherapp.presentation.state_test_screen.components

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Build
import android.os.CancellationSignal
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import com.example.mausamweatherapp.MainActivity
import com.example.mausamweatherapp.domain.model.WeatherRequired
import java.util.concurrent.Executor
import java.util.function.Consumer

//@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun DescriptionScreen(weather: WeatherRequired?, context: MainActivity) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier.padding(4.dp)
        ) {
            if (weather != null) {
                Text(
                    text = "Country: " + weather.country,
                    style = MaterialTheme.typography.h5
                )

                Text(
                    text = "Location: " + weather.state,
                    style = MaterialTheme.typography.h5
                )
            }
        }
    }
}