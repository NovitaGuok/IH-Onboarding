package com.example.ihonboarding.presentation.viewmodel.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.ihonboarding.domain.home.use_case.GetNewsUseCase
import com.example.ihonboarding.domain.home.use_case.UpdateNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel
@Inject constructor(
    private val getNewsUseCase: GetNewsUseCase,
    private val updateNewsUseCase: UpdateNewsUseCase
) : ViewModel() {
    fun getNews() = liveData {
        val newsList = getNewsUseCase.execute()
        emit(newsList)
    }

    fun updateNews() = liveData {
        val newsList = updateNewsUseCase.execute()
        emit(newsList)
    }
}