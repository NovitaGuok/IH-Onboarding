package com.example.ihonboarding.di.core

import com.example.ihonboarding.data.home.dao.NewsDao
import com.example.ihonboarding.data.home.data_source.local.NewsLocalDataSource
import com.example.ihonboarding.data.home.data_source.local.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Singleton

@Module
@DisableInstallInCheck
class LocalDataModule {
    @Singleton
    @Provides
    fun provideNewsLocalDataSource(newsDao: NewsDao): NewsLocalDataSource {
        return NewsLocalDataSourceImpl(newsDao)
    }
}