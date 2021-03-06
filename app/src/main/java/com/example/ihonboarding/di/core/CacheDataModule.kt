package com.example.ihonboarding.di.core

import com.example.ihonboarding.data.home.data_source.cache.NewsCacheDataSource
import com.example.ihonboarding.data.home.data_source.cache.NewsCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CacheDataModule {
    @Singleton
    @Provides
    fun provideNewsCacheDataSource(): NewsCacheDataSource {
        return NewsCacheDataSourceImpl()
    }
}