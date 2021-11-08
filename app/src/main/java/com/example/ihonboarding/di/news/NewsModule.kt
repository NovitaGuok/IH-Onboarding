package com.example.ihonboarding.di.news

import com.example.ihonboarding.domain.home.use_case.GetNewsUseCase
import com.example.ihonboarding.domain.home.use_case.UpdateNewsUseCase
import com.example.ihonboarding.presentation.viewmodel.home.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck

@Module
@DisableInstallInCheck
class NewsModule {
    @NewsScope
    @Provides
    fun provideNewsViewModelFactory(
        getNewsUseCase: GetNewsUseCase,
        updateNewsUseCase: UpdateNewsUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(getNewsUseCase, updateNewsUseCase)
    }
}