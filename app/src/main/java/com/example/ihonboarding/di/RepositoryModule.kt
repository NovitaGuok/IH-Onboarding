package com.example.ihonboarding.di

import com.example.ihonboarding.data_source.home.remote.repository.NewsRemoteDataSourceImpl
import com.example.ihonboarding.data_source.home.remote.repository.NewsRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideNewsRepository(newsRepositoryImpl: NewsRemoteDataSourceImpl): NewsRemoteDataSource
}