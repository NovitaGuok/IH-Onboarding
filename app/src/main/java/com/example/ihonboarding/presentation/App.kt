package com.example.ihonboarding.presentation

import android.app.Application
import com.example.ihonboarding.BuildConfig
import com.example.ihonboarding.di.Injector
import com.example.ihonboarding.di.core.*
import com.example.ihonboarding.di.news.NewsSubcomponent
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
//        appComponent = DaggerAppComponent.builder().appModule(AppModule(applicationContext))
//            .networkModule(NetworkModule(BuildConfig.BASE_URL))
//            .remoteDataModule(RemoteDataModule("Bearer dGVzdGVyfDIwMjEtMTEtMDVUMTI6MDY6MjRafGNlMWM2MTA2NzM3MWFiNzBhMDk0YWU0OTUxYmNkN2JlZTA2N2UyMTZmN2VkZDUyNDc2NzFhYTAwN2I2NzM1NTg=")).build()
    }

}