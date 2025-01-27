package com.aakash.daggerhiltcompatibility

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
class DaggerModule {

    @Provides
    @Singleton
    fun provideGreetingMessage(): String {
        return "Hello from Dagger!"
    }
}