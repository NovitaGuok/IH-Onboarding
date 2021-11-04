package com.example.ihonboarding.di

import com.example.ihonboarding.data.home.dao.NewsDao
import com.example.ihonboarding.data.home.data_source.local.NewsLocalDataSource
import com.example.ihonboarding.data.home.data_source.local.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {
    @Singleton
    @Provides
    fun provideNewsLocalDataSource(newsDao: NewsDao): NewsLocalDataSource {
        return NewsLocalDataSourceImpl(newsDao)
    }
}