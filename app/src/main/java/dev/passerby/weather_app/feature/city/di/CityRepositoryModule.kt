package dev.passerby.weather_app.feature.city.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.passerby.weather_app.feature.city.data.repository.CityRepositoryImpl
import dev.passerby.weather_app.feature.city.domain.repository.CityRepository
import dev.passerby.weather_app.feature.home.domain.repository.HomeRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CityRepositoryModule {
    @Binds
    @Singleton
    fun bindCityRepository(cityRepositoryImpl: CityRepositoryImpl): CityRepository
}