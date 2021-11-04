package com.example.ihonboarding.di.core

import com.example.ihonboarding.domain.home.repository.NewsRepository
import com.example.ihonboarding.domain.home.use_case.GetNewsUseCase
import com.example.ihonboarding.domain.home.use_case.UpdateNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck

@Module
@DisableInstallInCheck
class UseCaseModule {
    @Provides
    fun provideGetNewsUseCase(newsRepository: NewsRepository): GetNewsUseCase {
        return GetNewsUseCase(newsRepository)
    }

    @Provides
    fun provideUpdateNewsUseCase(newsRepository: NewsRepository): UpdateNewsUseCase {
        return UpdateNewsUseCase(newsRepository)
    }
}