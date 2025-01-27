package com.aakash.daggerhiltcompatibility

import android.content.Context
import com.philips.platform.appinfra.AppInfra
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun provideAppInfra(@ApplicationContext context: Context): AppInfra {
        return AppInfra.Builder().build(context)
    }
}