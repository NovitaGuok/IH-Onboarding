package com.example.ihonboarding.di

import com.example.ihonboarding.domain.login.repository.AuthRepository
import com.example.ihonboarding.domain.login.repository.ProfileRepository
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