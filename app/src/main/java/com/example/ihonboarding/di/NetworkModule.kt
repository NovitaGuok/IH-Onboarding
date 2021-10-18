package com.example.ihonboarding.di

import com.example.ihonboarding.network.NewsService
import com.example.ihonboarding.network.model.NewsDtoMapper
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideNewsMapper(): NewsDtoMapper {
        return NewsDtoMapper()
    }

    @Singleton
    @Provides
    fun provideNewsService(): NewsService {
        return Retrofit.Builder().baseUrl("http://34.121.153.157/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())).build()
            .create(NewsService::class.java)
    }

    @Singleton
    @Provides
    @Named("auth_token")
    fun provideAuthToken(): String {
        return "somerandomtoken"
    }
}