package com.example.ihonboarding.di

import android.content.Context
import com.example.ihonboarding.feature.login.data_source.local.SessionManager
import com.example.ihonboarding.feature.login.data_source.local.SessionManagerImpl
import com.example.ihonboarding.feature.login.data_source.remote.AuthRemoteDataSource
import com.example.ihonboarding.feature.login.data_source.remote.AuthRemoteDataSourceImpl
import com.example.ihonboarding.feature.login.data_source.remote.network.AuthService
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
}