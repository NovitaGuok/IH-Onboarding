package com.example.ihonboarding.di

import android.content.Context
import com.example.ihonboarding.feature.home.data_source.local.NewsLocalDataSource
import com.example.ihonboarding.feature.home.data_source.local.NewsLocalDataSourceImpl
import com.example.ihonboarding.feature.home.data_source.local.dao.NewsDao
import com.example.ihonboarding.feature.home.data_source.remote.NewsRemoteDataSource
import com.example.ihonboarding.feature.home.data_source.remote.NewsRemoteDataSourceImpl
import com.example.ihonboarding.feature.home.data_source.remote.api.NewsService
import com.example.ihonboarding.feature.login.data_source.local.ProfileLocalDataSource
import com.example.ihonboarding.feature.login.data_source.local.ProfileLocalDataSourceImpl
import com.example.ihonboarding.feature.login.data_source.local.SessionManager
import com.example.ihonboarding.feature.login.data_source.local.SessionManagerImpl
import com.example.ihonboarding.feature.login.data_source.local.dao.ProfileDao
import com.example.ihonboarding.feature.login.data_source.remote.AuthRemoteDataSource
import com.example.ihonboarding.feature.login.data_source.remote.AuthRemoteDataSourceImpl
import com.example.ihonboarding.feature.login.data_source.remote.ProfileRemoteDataSource
import com.example.ihonboarding.feature.login.data_source.remote.ProfileRemoteDataSourceImpl
import com.example.ihonboarding.feature.login.data_source.remote.network.AuthService
import com.example.ihonboarding.feature.login.data_source.remote.network.ProfileService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {
    @Provides
    fun provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource {
        return AuthRemoteDataSourceImpl(authService)
    }

    @Provides
    fun provideSessionManager(@ApplicationContext context: Context): SessionManager {
        return SessionManagerImpl(context)
    }

    @Provides
    fun provideProfileRemoteDataSource(profileService: ProfileService): ProfileRemoteDataSource {
        return ProfileRemoteDataSourceImpl(profileService)
    }

    @Provides
    fun provideProfileLocalDataSource(profileDao: ProfileDao): ProfileLocalDataSource {
        return ProfileLocalDataSourceImpl(profileDao)
    }

    @Provides
    fun provideNewsRemoteDataSource(
        newsService: NewsService,
        sessionManager: SessionManager
    ): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsService, sessionManager)
    }

    @Provides
    fun provideNewsLocalDataSource(
        newsDao: NewsDao
    ): NewsLocalDataSource {
        return NewsLocalDataSourceImpl(newsDao)
    }
}