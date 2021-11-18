package com.example.ihonboarding.presentation

import android.app.Application
import com.example.ihonboarding.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class IhOnboardingApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        if(BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}