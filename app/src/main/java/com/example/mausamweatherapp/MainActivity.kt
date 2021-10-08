package com.example.mausamweatherapp

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.core.content.PermissionChecker.*
import com.example.mausamweatherapp.presentation.state_test_screen.StateViewModel
import com.example.mausamweatherapp.presentation.state_test_screen.StateWeatherScreen
import com.example.mausamweatherapp.presentation.ui.theme.MausamWeatherAppTheme
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.DialogOnDeniedPermissionListener
import com.karumi.dexter.listener.single.PermissionListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MausamWeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val per = rememberSaveable { mutableStateOf<Boolean>(false) }
                    val scrollState = rememberScrollState()

                    Dexter.withContext(this)
                        .withPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
                        .withListener(object : PermissionListener {
                            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {

                                per.value = true
                            }

                            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                              per.value = false;
                                val dialog = DialogOnDeniedPermissionListener
                                    .Builder.withContext(this@MainActivity)
                                    .withMessage("App will not work without Location Permission!")
                                    .withButtonText("Ok")
                                    .withTitle("Alert")
                                    .withIcon(R.drawable.ic_error)
                                    .build()

                                dialog.onPermissionDenied(p0)

                            }

                            override fun onPermissionRationaleShouldBeShown(
                                p0: PermissionRequest?,
                                p1: PermissionToken?
                            ) {
                                p1?.continuePermissionRequest()
                            }
                        }).check()

                    val nestedScrollConnection: NestedScrollConnection

                    if(per.value){

                        Column() {
                            StateWeatherScreen()
                        }

                    }
                }
            }
        }
    }
}

