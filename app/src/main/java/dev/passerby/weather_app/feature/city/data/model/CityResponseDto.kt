package dev.passerby.weather_app.feature.city.data.model

import dev.passerby.weather_app.feature.city.domain.model.CityModel
import kotlinx.serialization.Serializable

@Serializable
class CityResponseDto : ArrayList<CityDto>()

fun CityResponseDto.toDomain(): List<CityModel>{
    return this.map { it.toDomain() }
}