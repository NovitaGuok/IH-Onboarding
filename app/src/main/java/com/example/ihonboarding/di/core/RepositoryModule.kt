package com.example.ihonboarding.di.core

import com.example.ihonboarding.data.home.data_source.cache.NewsCacheDataSource
import com.example.ihonboarding.data.home.data_source.local.NewsLocalDataSource
import com.example.ihonboarding.data.home.data_source.remote.NewsRemoteDataSource
import com.example.ihonboarding.data.home.repository.NewsRepositoryImpl
import com.example.ihonboarding.domain.home.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource,
        newsLocalDataSource: NewsLocalDataSource,
        newsCacheDataSource: NewsCacheDataSource
    ): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource, newsLocalDataSource, newsCacheDataSource)
    }
}