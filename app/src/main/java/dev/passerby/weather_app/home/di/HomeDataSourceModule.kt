package dev.passerby.weather_app.home.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.passerby.weather_app.home.data.api.HomeService
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeDataSourceModule {
    @Provides
    @Singleton
    fun provideHomeService(retrofit: Retrofit): HomeService = retrofit.create()
}