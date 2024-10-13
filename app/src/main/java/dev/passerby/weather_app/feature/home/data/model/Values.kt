package dev.passerby.weather_app.feature.home.data.model

import dev.passerby.weather_app.feature.home.domain.model.ValuesModel
import kotlinx.serialization.Serializable

@Serializable
data class Values(
    val cloudBase: Double?,
    val cloudCeiling: Double?,
    val cloudCover: Int,
    val dewPoint: Double,
    val freezingRainIntensity: Int,
    val humidity: Int,
    val precipitationProbability: Int,
    val pressureSurfaceLevel: Double,
    val rainIntensity: Int,
    val sleetIntensity: Int,
    val snowIntensity: Int,
    val temperature: Double,
    val temperatureApparent: Double,
    val uvHealthConcern: Int,
    val uvIndex: Int,
    val visibility: Int,
    val weatherCode: Int,
    val windDirection: Double,
    val windGust: Double,
    val windSpeed: Double
)

fun Values.toDomain() = ValuesModel(
    humidity = this.humidity,
    precipitationProbability = this.precipitationProbability,
    temperature = this.temperature,
    weatherCode = this.weatherCode
)