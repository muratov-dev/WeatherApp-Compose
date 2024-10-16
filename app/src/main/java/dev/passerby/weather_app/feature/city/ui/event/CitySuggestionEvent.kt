package dev.passerby.weather_app.feature.city.ui.event

import dev.passerby.weather_app.feature.city.domain.model.CityModel

sealed interface CitySuggestionEvent {
    data class OnCityNameInput(val name: String) : CitySuggestionEvent
    data class OnCityClick(val city: CityModel) : CitySuggestionEvent
    data object OnCityConfirmClick : CitySuggestionEvent
}