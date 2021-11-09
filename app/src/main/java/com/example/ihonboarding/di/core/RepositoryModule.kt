package com.example.ihonboarding.di.core

import com.example.ihonboarding.data.home.data_source.remote.api.NewsService
import com.example.ihonboarding.data.home.repository.NewsRepositoryImpl
import com.example.ihonboarding.domain.home.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideNewsRepository(newsService: NewsService): NewsRepository {
        return NewsRepositoryImpl(newsService)
    }
}