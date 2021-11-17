package com.example.ihonboarding.di

import android.content.Context
import com.example.ihonboarding.domain.login.repository.AuthRepository
import com.example.ihonboarding.domain.login.use_case.LoginUseCase
import com.example.ihonboarding.domain.login.use_case.RefreshTokenUseCase
import com.example.ihonboarding.feature.login.data_source.local.SessionManager
import com.example.ihonboarding.feature.login.data_source.local.SessionManagerImpl
import com.example.ihonboarding.feature.login.data_source.remote.AuthRemoteDataSource
import com.example.ihonboarding.feature.login.data_source.remote.AuthRemoteDataSourceImpl
import com.example.ihonboarding.feature.login.data_source.remote.network.AuthService
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
    fun provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource {
        return AuthRemoteDataSourceImpl(authService)
    }

    @Provides
    fun provideSessionManager(@ApplicationContext context: Context): SessionManager {
        return SessionManagerImpl(context)
    }

    @Provides
    fun provideAuthRepository(
        authRemoteDataSource: AuthRemoteDataSource,
        sessionManager: SessionManager
    ): AuthRepository {
        return AuthRepositoryImpl(authRemoteDataSource, sessionManager)
    }

    @Provides
    fun provideLoginUseCase(authRepository: AuthRepository): LoginUseCase {
        return LoginUseCase(authRepository)
    }

    @Provides
    fun provideRefreshTokenUseCase(authRepository: AuthRepository): RefreshTokenUseCase {
        return RefreshTokenUseCase(authRepository)
    }
}