package dev.passerby.weather_app.feature.city.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CityModel(
    val country: String,
    val latitude: Double,
    val longitude: Double,
    val name: String,
    var isChecked: Boolean = false
)