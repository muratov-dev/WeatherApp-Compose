package dev.passerby.weather_app.home.domain.repository

import dev.passerby.weather_app.home.domain.model.DataModel

interface HomeRepository {
    suspend fun getRealtimeWeather(): DataModel?
}