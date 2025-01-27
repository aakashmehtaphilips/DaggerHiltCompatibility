package com.aakash.daggerhiltcompatibility

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DaggerModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}