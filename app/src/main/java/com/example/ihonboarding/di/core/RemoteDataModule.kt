package com.example.ihonboarding.di.core

import com.example.ihonboarding.data.home.api.NewsService
import com.example.ihonboarding.data.home.data_source.remote.NewsRemoteDataSource
import com.example.ihonboarding.data.home.data_source.remote.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Singleton

@Module
@DisableInstallInCheck
class RemoteDataModule(private val authorizations: String) {
    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(newsService: NewsService): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsService, authorizations)
    }
}