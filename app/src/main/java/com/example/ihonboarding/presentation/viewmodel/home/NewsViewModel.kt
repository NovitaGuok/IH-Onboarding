package com.example.ihonboarding.presentation.viewmodel.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.example.ihonboarding.data.home.model.News
import com.example.ihonboarding.domain.home.use_case.GetNewsUseCase
import com.example.ihonboarding.domain.home.use_case.UpdateNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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