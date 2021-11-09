package com.example.ihonboarding.di.core

import android.content.Context
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module()
@InstallIn(SingletonComponent::class)
class AppModule(private val context: Context) {
//    @Singleton
//    @Provides
//    fun provideApplication(): Context {
//        return context.applicationContext
//    }
}