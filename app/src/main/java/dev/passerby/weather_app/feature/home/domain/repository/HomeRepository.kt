package dev.passerby.weather_app.feature.home.domain.repository

import dev.passerby.weather_app.feature.home.domain.model.DataModel

interface HomeRepository {
    suspend fun getRealtimeWeather(): DataModel?
}