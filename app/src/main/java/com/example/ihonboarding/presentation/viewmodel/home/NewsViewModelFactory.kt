package com.example.ihonboarding.presentation.viewmodel.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ihonboarding.domain.home.use_case.GetNewsUseCase
import com.example.ihonboarding.domain.home.use_case.UpdateNewsUseCase

class NewsViewModelFactory(
    private val getNewsUseCase: GetNewsUseCase,
    private val updateNewsUseCase: UpdateNewsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(getNewsUseCase, updateNewsUseCase) as T
    }
}