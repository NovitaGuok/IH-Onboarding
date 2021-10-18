package com.example.ihonboarding.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ihonboarding.domain.model.News
import com.example.ihonboarding.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class NewsListViewModel
@Inject constructor(
    private val repository: NewsRepository,
    private @Named("auth_token") val token: String
) :
    ViewModel() {
    val news: MutableState<List<News>> = mutableStateOf(listOf())

    init {
        viewModelScope.launch {
            val result = repository.search(
                token = token,
                page = 1,
                query = "Sample Title"
            )
            news.value = result
        }
    }
}