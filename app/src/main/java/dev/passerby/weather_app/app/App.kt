package dev.passerby.weather_app.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dev.passerby.weather_app.BuildConfig
import dev.passerby.weather_app.feature.home.domain.repository.HomeRepository
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}