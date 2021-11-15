package com.example.ihonboarding.di

import android.content.Context
import com.example.ihonboarding.domain.login.repository.AuthRepository
import com.example.ihonboarding.feature.login.data_source.local.AuthLocalDataSource
import com.example.ihonboarding.feature.login.data_source.local.AuthLocalDataSourceImpl
import com.example.ihonboarding.feature.login.data_source.remote.AuthRemoteDataSource
import com.example.ihonboarding.feature.login.data_source.remote.AuthRemoteDataSourceImpl
import com.example.ihonboarding.feature.login.data_source.remote.api.AuthService
import com.example.ihonboarding.feature.login.repository.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun provideAuthRemoteDataSource(
        authService: AuthService
    ): AuthRemoteDataSource {
        return AuthRemoteDataSourceImpl(authService)
    }

    @Provides
    fun provideAuthLocalDataSource(
        @ApplicationContext context: Context
    ): AuthLocalDataSource {
        return AuthLocalDataSourceImpl()
    }

    @Provides
    fun provideAuthRepository(
        authRemoteDataSource: AuthRemoteDataSource,
        authLocalDataSource: AuthLocalDataSource
    ): AuthRepository {
        return AuthRepositoryImpl(authRemoteDataSource, authLocalDataSource)
    }
}