package dev.passerby.weather_app.feature.home.domain.model


import kotlinx.serialization.Serializable

@Serializable
data class DataModel(
    val time: String,
    val values: ValuesModel
)