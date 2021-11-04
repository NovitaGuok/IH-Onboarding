package com.example.ihonboarding.di.core

import android.content.Context
import com.example.ihonboarding.di.news.NewsSubcomponent
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Singleton

@Module(subcomponents = [NewsSubcomponent::class])
@DisableInstallInCheck
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideApplication(): Context {
        return context.applicationContext
    }
}