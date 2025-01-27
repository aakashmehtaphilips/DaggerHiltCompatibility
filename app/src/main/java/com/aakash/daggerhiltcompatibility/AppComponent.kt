package com.aakash.daggerhiltcompatibility

import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}