package dev.passerby.weather_app.feature.city.data.model

import dev.passerby.weather_app.feature.city.domain.model.CityModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CityDto(
    val country: String,
    @SerialName("is_capital") val isCapital: Boolean,
    val latitude: Double,
    val longitude: Double,
    val name: String,
    val population: Int
)
fun CityDto.toDomain() = CityModel(
    country = country,
    latitude = latitude,
    longitude = longitude,
    name = name
)