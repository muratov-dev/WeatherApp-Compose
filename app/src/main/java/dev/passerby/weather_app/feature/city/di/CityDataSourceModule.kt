package dev.passerby.weather_app.feature.city.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.passerby.weather_app.core.network.di.CityRetrofitClient
import dev.passerby.weather_app.feature.city.data.source.CityRemoteDataSource
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CityDataSourceModule {

    @Provides
    @Singleton
    fun provideCityDataSource(@CityRetrofitClient retrofit: Retrofit): CityRemoteDataSource = retrofit.create()
}