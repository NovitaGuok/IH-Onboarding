package com.example.ihonboarding.di

import android.content.Context
import com.example.ihonboarding.data.local.dao.AuthTokenDao
import com.example.ihonboarding.data.local.AuthPrefsManager
import com.example.ihonboarding.data.local.mapper.AuthTokenEntityMapper
import com.example.ihonboarding.data.network.mapper.AuthTokenDtoMapper
import com.example.ihonboarding.data.network.source.AuthTokenRemoteSource
import com.example.ihonboarding.repository.auth.AuthRepository
import com.example.ihonboarding.repository.auth.AuthRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    fun provideAuthPrefsManager(@ApplicationContext appContext: Context): AuthPrefsManager {
        return AuthPrefsManager(appContext)
    }

    @Binds
    abstract fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository
}