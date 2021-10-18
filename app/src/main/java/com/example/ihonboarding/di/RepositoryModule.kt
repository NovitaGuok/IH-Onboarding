package com.example.ihonboarding.di

import com.example.ihonboarding.network.NewsService
import com.example.ihonboarding.network.model.NewsDtoMapper
import com.example.ihonboarding.repository.NewsRepository
import com.example.ihonboarding.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideNewsRepository(
        newsService: NewsService,
        newsDtoMapper: NewsDtoMapper
    ): NewsRepository {
        return NewsRepositoryImpl(newsService, newsDtoMapper)
    }
}