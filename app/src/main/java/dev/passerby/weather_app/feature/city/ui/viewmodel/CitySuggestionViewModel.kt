package dev.passerby.weather_app.feature.city.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.passerby.weather_app.feature.city.domain.model.CityModel
import dev.passerby.weather_app.feature.city.domain.usecase.GetCitySuggestionListUseCase
import dev.passerby.weather_app.feature.city.ui.event.CitySuggestionEvent
import dev.passerby.weather_app.feature.city.ui.event.CitySuggestionOneTimeEvent
import dev.passerby.weather_app.feature.city.ui.state.CitySuggestionUiState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CitySuggestionViewModel @Inject constructor(
    private val getCSLUseCase: GetCitySuggestionListUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CitySuggestionUiState())
    val uiState = _uiState.asStateFlow()

    private val _uiEvent = Channel<CitySuggestionOneTimeEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: CitySuggestionEvent) {
        when (event) {
            is CitySuggestionEvent.OnCityClick -> {
                val citiesList = uiState.value.citySuggestionList
                val checkedCityFromList: CityModel? =
                    citiesList.find { it.latitude == event.city.latitude && it.longitude == event.city.longitude }
                if (checkedCityFromList != null && checkedCityFromList.isChecked) {
                    val updatedList = citiesList.map { city ->
                        city.copy(isChecked = false)
                    }
                    _uiState.update { state ->
                        state.copy(
                            checkedCity = null, citySuggestionList = updatedList
                        )
                    }
                    return
                }
                val updatedList = citiesList.map { city ->
                    city.copy(isChecked = city == event.city)
                }
                _uiState.update { state ->
                    state.copy(
                        checkedCity = event.city,
                        citySuggestionList = updatedList,
                        confirmButtonIsEnabled = true
                    )
                }
            }

            is CitySuggestionEvent.OnCityConfirmClick -> {}
            is CitySuggestionEvent.OnCityNameInput -> {
                requestCitySuggestionList(event.name)
            }
        }
    }

    private fun requestCitySuggestionList(name: String) {
        viewModelScope.launch {
            getCSLUseCase(name).collectLatest { response ->
                response.on(loading = { _uiState.update { state -> state.copy(isLoading = true) } },
                    success = { data ->
                        _uiState.update { state ->
                            state.copy(isLoading = false, citySuggestionList = data)
                        }
                    },
                    error = { errorType ->
                        _uiState.update { state -> state.copy(isLoading = false) }
                        _uiEvent.send(CitySuggestionOneTimeEvent.ShowRequestError(errorType))
                    })
            }
        }
    }
}