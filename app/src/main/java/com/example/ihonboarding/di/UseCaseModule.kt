package com.example.ihonboarding.di

import com.example.ihonboarding.domain.home.repository.NewsRepository
import com.example.ihonboarding.domain.home.use_case.GetNewsUseCase
import com.example.ihonboarding.domain.login.repository.AuthRepository
import com.example.ihonboarding.domain.login.repository.ProfileRepository
import com.example.ihonboarding.domain.login.use_case.GetProfileUseCase
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

    @Provides
    fun provideGetProfileUseCase(profileRepository: ProfileRepository): GetProfileUseCase {
        return GetProfileUseCase(profileRepository)
    }

    @Provides
    fun provideGetNewsUseCase(newsRepository: NewsRepository): GetNewsUseCase {
        return GetNewsUseCase(newsRepository)
    }
}