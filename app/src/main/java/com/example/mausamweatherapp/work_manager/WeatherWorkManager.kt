package com.example.mausamweatherapp.work_manager

import android.content.Context
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.mausamweatherapp.presentation.state_test_screen.StateViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
/**
 * Note: Work Manager is not implemented
 *
 * */
class WeatherWorkManager @Inject constructor(
    val viewModel: StateViewModel,
    val context: Context,
    workerParameters: WorkerParameters
) : Worker(context, workerParameters) {

    override fun doWork(): Result {
//        val repository = context.applicationContext.

        return Result.success()
    }
}