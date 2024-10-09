package dev.passerby.weather_app.home.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val lat: Double,
    val lon: Double
)