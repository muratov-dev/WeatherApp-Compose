package dev.passerby.weather_app.home.data.api

import dev.passerby.weather_app.home.data.model.RealtimeWeatherDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeService {

    @GET("realtime")
    suspend fun getRealtimeWeather(
        @Query("location") location: String,
        @Query("apikey") apiKey: String
    ): Response<RealtimeWeatherDto>
}