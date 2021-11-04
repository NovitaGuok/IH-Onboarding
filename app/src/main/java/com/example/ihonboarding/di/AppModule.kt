package com.example.ihonboarding.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideApplication(): Context {
        return context.applicationContext
    }
}