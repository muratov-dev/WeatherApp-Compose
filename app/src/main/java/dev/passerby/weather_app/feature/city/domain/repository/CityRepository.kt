package dev.passerby.weather_app.feature.city.domain.repository

import dev.passerby.weather_app.core.datastate.DataState
import dev.passerby.weather_app.feature.city.domain.model.CityModel

interface CityRepository {

    suspend fun getCitiesSuggestionList(name: String): DataState<List<CityModel>>
}