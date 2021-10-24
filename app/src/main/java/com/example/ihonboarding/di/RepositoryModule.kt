package com.example.ihonboarding.di

import android.content.Context
import com.example.ihonboarding.data.local.dao.AuthTokenDao
import com.example.ihonboarding.data.local.AuthPrefsManager
import com.example.ihonboarding.data.local.mapper.AuthTokenEntityMapper
import com.example.ihonboarding.data.network.mapper.AuthTokenDtoMapper
import com.example.ihonboarding.data.network.source.AuthTokenRemoteSource
import com.example.ihonboarding.repository.auth.AuthRepository
import com.example.ihonboarding.repository.auth.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideAuthPrefsManager(@ApplicationContext context: Context): AuthPrefsManager {
        return AuthPrefsManager(context)
    }

    @Provides
    fun provideAuthRepository(
        authTokenRemoteSource: AuthTokenRemoteSource,
        authTokenDao: AuthTokenDao,
        authTokenDtoMapper: AuthTokenDtoMapper,
        authTokenEntityMapper: AuthTokenEntityMapper,
        authPrefsManager: AuthPrefsManager
    ): AuthRepository {
        return AuthRepositoryImpl(
            authTokenRemoteSource = authTokenRemoteSource,
            authTokenDao = authTokenDao,
            authTokenDtoMapper = authTokenDtoMapper,
            authTokenEntityMapper = authTokenEntityMapper,
            authPrefsManager = authPrefsManager
        )
    }
}