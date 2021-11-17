package com.example.ihonboarding.di

import com.example.ihonboarding.domain.login.repository.AuthRepository
import com.example.ihonboarding.domain.login.use_case.LoginUseCase
import com.example.ihonboarding.domain.login.use_case.RefreshTokenUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    fun provideLoginUseCase(authRepository: AuthRepository): LoginUseCase {
        return LoginUseCase(authRepository)
    }

    @Provides
    fun provideRefreshTokenUseCase(authRepository: AuthRepository): RefreshTokenUseCase {
        return RefreshTokenUseCase(authRepository)
    }
}