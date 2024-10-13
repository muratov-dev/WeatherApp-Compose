package dev.passerby.weather_app.feature.city.domain.usecase

import dev.passerby.weather_app.core.datastate.DataState
import dev.passerby.weather_app.feature.city.domain.model.CityModel
import dev.passerby.weather_app.feature.city.domain.repository.CityRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class GetCitySuggestionListUseCase @Inject constructor(private val repository: CityRepository) {
    operator fun invoke(name: String): Flow<DataState<List<CityModel>>> = flow {
        emit(repository.getCitiesSuggestionList(name))
    }.onStart { emit(DataState.Loading()) }.flowOn(Dispatchers.IO)
}