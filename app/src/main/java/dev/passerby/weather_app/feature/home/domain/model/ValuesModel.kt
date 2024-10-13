package dev.passerby.weather_app.feature.home.domain.model


import kotlinx.serialization.Serializable

@Serializable
data class ValuesModel(
    val humidity: Int,
    val precipitationProbability: Int,
    val temperature: Double,
    val weatherCode: Int
)