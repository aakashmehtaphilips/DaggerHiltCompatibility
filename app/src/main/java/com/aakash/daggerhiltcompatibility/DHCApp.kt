package com.aakash.daggerhiltcompatibility

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DHCApp : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .daggerModule(DaggerModule())
            .build()
    }
}