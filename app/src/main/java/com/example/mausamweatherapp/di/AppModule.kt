package com.example.mausamweatherapp.di



import com.example.mausamweatherapp.common.Constants
import com.example.mausamweatherapp.data.remote.WeatherApi
import com.example.mausamweatherapp.data.repository.WeatherRepositoryImpl
import com.example.mausamweatherapp.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesPaprikaApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun providesRepository(api: WeatherApi) : WeatherRepository {
        return WeatherRepositoryImpl(api)
    }


}