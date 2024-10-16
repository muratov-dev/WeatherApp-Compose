package dev.passerby.weather_app.feature.city.ui.event

import dev.passerby.weather_app.core.datastate.ErrorType

sealed interface CitySuggestionOneTimeEvent {
    data class ShowRequestError(val errorType: ErrorType): CitySuggestionOneTimeEvent
}