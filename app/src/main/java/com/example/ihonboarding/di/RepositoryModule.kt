package com.example.ihonboarding.di

import com.example.ihonboarding.domain.home.repository.NewsRepository
import com.example.ihonboarding.domain.login.repository.AuthRepository
import com.example.ihonboarding.domain.login.repository.ProfileRepository
import com.example.ihonboarding.feature.home.data_source.local.NewsLocalDataSource
import com.example.ihonboarding.feature.home.data_source.local.NewsLocalDataSourceImpl
import com.example.ihonboarding.feature.home.data_source.local.dao.NewsDao
import com.example.ihonboarding.feature.home.data_source.remote.NewsRemoteDataSource
import com.example.ihonboarding.feature.home.data_source.remote.NewsRemoteDataSourceImpl
import com.example.ihonboarding.feature.home.data_source.remote.api.NewsService
import com.example.ihonboarding.feature.home.repository.NewsRepositoryImpl
import com.example.ihonboarding.feature.login.data_source.local.ProfileLocalDataSource
import com.example.ihonboarding.feature.login.data_source.local.SessionManager
import com.example.ihonboarding.feature.login.data_source.remote.AuthRemoteDataSource
import com.example.ihonboarding.feature.login.data_source.remote.ProfileRemoteDataSource
import com.example.ihonboarding.feature.login.repository.AuthRepositoryImpl
import com.example.ihonboarding.feature.login.repository.ProfileRepositoryImpl
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
    fun provideAuthRepository(
        authRemoteDataSource: AuthRemoteDataSource,
        sessionManager: SessionManager
    ): AuthRepository {
        return AuthRepositoryImpl(authRemoteDataSource, sessionManager)
    }

    @Provides
    fun provideProfileRepository(
        profileRemoteDataSource: ProfileRemoteDataSource,
        profileLocalDataSource: ProfileLocalDataSource
    ): ProfileRepository {
        return ProfileRepositoryImpl(profileRemoteDataSource, profileLocalDataSource)
    }
}