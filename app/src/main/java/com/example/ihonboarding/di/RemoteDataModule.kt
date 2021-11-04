package com.example.ihonboarding.di

import com.example.ihonboarding.data.home.api.NewsService
import com.example.ihonboarding.data.home.data_source.remote.NewsRemoteDataSource
import com.example.ihonboarding.data.home.data_source.remote.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule(private val authorizations: String) {
    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(newsService: NewsService): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsService, authorizations)
    }
}