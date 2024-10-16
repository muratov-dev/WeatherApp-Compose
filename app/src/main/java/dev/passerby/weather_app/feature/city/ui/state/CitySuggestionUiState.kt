package dev.passerby.weather_app.feature.city.ui.state

import androidx.compose.runtime.Immutable
import dev.passerby.weather_app.feature.city.domain.model.CityModel

@Immutable
data class CitySuggestionUiState(
    val isLoading: Boolean = false,
    var name: String? = null,
    val checkedCity: CityModel? = null,
    val citySuggestionList: List<CityModel> = emptyList(),
    val confirmButtonIsEnabled: Boolean = false,
    val isSuggestionListContainerVisible: Boolean = false
)