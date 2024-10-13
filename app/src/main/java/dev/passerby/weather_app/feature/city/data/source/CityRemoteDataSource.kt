package dev.passerby.weather_app.feature.city.data.source

import dev.passerby.weather_app.BuildConfig
import dev.passerby.weather_app.feature.city.data.model.CityDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CityRemoteDataSource {

    @GET("city")
    @Headers("X-Api-Key: ${BuildConfig.CITY_API_KEY}")
    suspend fun getCitySuggestionList(
        @Query("name") name: String = "",
        @Query("min_population") minPopulation: Int = 15000,
        @Query("limit") limit: Int = 30
    ): Response<ArrayList<CityDto>>
}