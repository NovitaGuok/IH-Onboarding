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
class RepositoryModule @Inject constructor() {
    @Inject @ApplicationContext lateinit var context: Context
    @Inject lateinit var authTokenRemoteSource: AuthTokenRemoteSource
    @Inject lateinit var authTokenDao: AuthTokenDao
    @Inject lateinit var authTokenDtoMapper: AuthTokenDtoMapper
    @Inject lateinit var authTokenEntityMapper: AuthTokenEntityMapper
    @Inject lateinit var authPrefsManager: AuthPrefsManager

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