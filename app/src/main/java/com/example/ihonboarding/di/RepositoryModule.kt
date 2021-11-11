package com.example.ihonboarding.di

import com.example.ihonboarding.domain.home.repository.NewsRepository
import com.example.ihonboarding.domain.home.use_case.GetNewsUseCase
import com.example.ihonboarding.feature.home.data_source.local.NewsLocalDataSource
import com.example.ihonboarding.feature.home.data_source.local.NewsLocalDataSourceImpl
import com.example.ihonboarding.feature.home.data_source.local.dao.NewsDao
import com.example.ihonboarding.feature.home.data_source.remote.NewsRemoteDataSource
import com.example.ihonboarding.feature.home.data_source.remote.NewsRemoteDataSourceImpl
import com.example.ihonboarding.feature.home.data_source.remote.api.NewsService
import com.example.ihonboarding.feature.home.repository.NewsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun provideNewsRemoteDataSource(
        newsService: NewsService
    ): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsService)
    }

    @Provides
    fun provideNewsLocalDataSource(
        newsDao: NewsDao
    ): NewsLocalDataSource {
        return NewsLocalDataSourceImpl(newsDao)
    }

    @Provides
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource,
        newsLocalDataSource: NewsLocalDataSource
    ): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource, newsLocalDataSource)
    }

    @Provides
    fun provideGetNewsUseCase(newsRepository: NewsRepository): GetNewsUseCase {
        return GetNewsUseCase(newsRepository)
    }
}