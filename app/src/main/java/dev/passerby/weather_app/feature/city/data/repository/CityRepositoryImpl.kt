package dev.passerby.weather_app.feature.city.data.repository

import dev.passerby.weather_app.core.datastate.DataState
import dev.passerby.weather_app.core.datastate.dataRequest
import dev.passerby.weather_app.core.network.exception.RequestResponseException
import dev.passerby.weather_app.feature.city.data.model.toDomain
import dev.passerby.weather_app.feature.city.data.source.CityRemoteDataSource
import dev.passerby.weather_app.feature.city.domain.model.CityModel
import dev.passerby.weather_app.feature.city.domain.repository.CityRepository
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(private val dataSource: CityRemoteDataSource) : CityRepository {

    override suspend fun getCitiesSuggestionList(name: String): DataState<List<CityModel>> {
        return dataRequest {
            dataSource.getCitySuggestionList(name).body()?.map { it.toDomain() } ?: throw RequestResponseException()
        }
    }
}