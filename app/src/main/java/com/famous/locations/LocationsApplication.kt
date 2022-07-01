package com.famous.locations

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class LocationsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

    }

}