package dev.passerby.weather_app.core.network.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.passerby.weather_app.BuildConfig
import dev.passerby.weather_app.core.network.NetworkConnectionInterceptor
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val OK_HTTP_TIMEOUT = 10L

    @Singleton
    @Provides
    fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(NetworkConnectionInterceptor(context))
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(OK_HTTP_TIMEOUT, TimeUnit.SECONDS).readTimeout(0, TimeUnit.SECONDS)
            .writeTimeout(0, TimeUnit.SECONDS).build()
    }

    @CityRetrofitClient
    @Singleton
    @Provides
    fun provideCityRetrofitClient(json: Json, okHttpClient: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()

        return Retrofit.Builder().addConverterFactory(json.asConverterFactory(contentType))
            .baseUrl(BuildConfig.CITY_BASE_URL).client(okHttpClient).build()
    }

    @WeatherRetrofitClient
    @Singleton
    @Provides
    fun provideWeatherRetrofitClient(json: Json, okHttpClient: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()

        return Retrofit.Builder().addConverterFactory(json.asConverterFactory(contentType))
            .baseUrl(BuildConfig.WEATHER_BASE_URL).client(okHttpClient).build()
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CityRetrofitClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class WeatherRetrofitClient