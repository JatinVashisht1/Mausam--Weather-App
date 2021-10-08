package com.example.mausamweatherapp

import android.app.Application
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.example.mausamweatherapp.data.repository.WeatherRepositoryImpl
import com.example.mausamweatherapp.presentation.state_test_screen.StateViewModel
import com.example.mausamweatherapp.work_manager.WeatherWorkManager
import dagger.hilt.android.HiltAndroidApp
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltAndroidApp
class WeatherApplication @Inject constructor() : Application(){
//    val viewModel: StateViewModel by viewModels()
    override fun onCreate() {
        super.onCreate()
        initialize()
        setupWorker()
    }

    private fun setupWorker() {
        val constraint = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
        val workerRequest = PeriodicWorkRequest.Builder(WeatherWorkManager::class.java, 1, TimeUnit.HOURS)
            .setConstraints(constraint)
            .build()
        WorkManager.getInstance(this).enqueue(workerRequest)
    }

    private fun initialize(){

    }
}