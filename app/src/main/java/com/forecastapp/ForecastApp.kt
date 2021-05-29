package com.forecastapp

import android.app.Application
import timber.log.Timber

class ForecastApp : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}