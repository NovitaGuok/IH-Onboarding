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
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule @Inject constructor(
    @ApplicationContext private val context: Context,
    private val authTokenRemoteSource: AuthTokenRemoteSource,
    private val authTokenDao: AuthTokenDao,
    private val authTokenDtoMapper: AuthTokenDtoMapper,
    private val authTokenEntityMapper: AuthTokenEntityMapper,
    private val authPrefsManager: AuthPrefsManager
) {
    fun provideAuthPrefsManager(): AuthPrefsManager {
        return AuthPrefsManager(context)
    }

    fun provideAuthRepository(): AuthRepository {
        return AuthRepositoryImpl(
            authTokenRemoteSource = authTokenRemoteSource,
            authTokenDao = authTokenDao,
            authTokenDtoMapper = authTokenDtoMapper,
            authTokenEntityMapper = authTokenEntityMapper,
            authPrefsManager = authPrefsManager
        )
    }
}