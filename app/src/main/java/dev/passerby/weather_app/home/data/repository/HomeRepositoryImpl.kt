package dev.passerby.weather_app.home.data.repository

import dev.passerby.weather_app.BuildConfig
import dev.passerby.weather_app.home.data.api.HomeService
import dev.passerby.weather_app.home.data.model.toDomain
import dev.passerby.weather_app.home.domain.model.DataModel
import dev.passerby.weather_app.home.domain.repository.HomeRepository
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepositoryImpl @Inject constructor(
    private val homeService: HomeService
) : HomeRepository {

    override suspend fun getRealtimeWeather(): DataModel? {
        val realtimeWeather = homeService.getRealtimeWeather("Simferopol", BuildConfig.TOMORROW_API_KEY)
        return realtimeWeather.body()?.weatherData?.toDomain()
    }
}