package dev.passerby.weather_app.home.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RealtimeWeatherDto(
    @SerialName("data")
    val weatherData: Data,
    val location: Location
)