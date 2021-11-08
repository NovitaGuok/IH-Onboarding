package com.example.ihonboarding.di.core

import com.example.ihonboarding.data.home.api.NewsService
import com.example.ihonboarding.data.home.data_source.remote.NewsRemoteDataSource
import com.example.ihonboarding.data.home.data_source.remote.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule() {
    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(newsService: NewsService): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsService, "Bearer dGVzdGVyfDIwMjEtMTEtMDVUMTI6MDY6MjRafGNlMWM2MTA2NzM3MWFiNzBhMDk0YWU0OTUxYmNkN2JlZTA2N2UyMTZmN2VkZDUyNDc2NzFhYTAwN2I2NzM1NTg=")
    }
}