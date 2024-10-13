package dev.passerby.weather_app.feature.home.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.passerby.weather_app.feature.home.data.repository.HomeRepositoryImpl
import dev.passerby.weather_app.feature.home.domain.repository.HomeRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface HomeRepositoryModule {
    @Binds
    @Singleton
    fun bindGameRepository(defaultAuthRepository: HomeRepositoryImpl): HomeRepository
}