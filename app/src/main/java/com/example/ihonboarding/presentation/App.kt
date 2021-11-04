package com.example.ihonboarding.presentation

import android.app.Application
import com.example.ihonboarding.BuildConfig
import com.example.ihonboarding.di.Injector
import com.example.ihonboarding.di.core.*
import com.example.ihonboarding.di.news.NewsSubcomponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(applicationContext))
            .networkModule(NetworkModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule("authorizations")).build()
    }

    override fun createNewsSubcomponent(): NewsSubcomponent {
        return appComponent.newsSubcomponent().create()
    }

}