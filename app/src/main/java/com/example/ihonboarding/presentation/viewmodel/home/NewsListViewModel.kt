package com.example.ihonboarding.presentation.viewmodel.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ihonboarding.domain.home.use_case.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel
@Inject constructor(
    private val getNewsUseCase: GetNewsUseCase,
) : ViewModel() {
    private val _newsState = mutableStateOf(NewsListState())
    val newsState: State<NewsListState> = _newsState

    init {
        getNewsList()
    }

    private fun getNewsList() {
        _newsState.value = NewsListState(isLoading = true)
        getNewsUseCase.getNewsList().onEach { res ->
            _newsState.value = newsState.value.copy(newsList = res)
            Log.d("viewModel", res.toString())
        }.catch { e ->
            _newsState.value = NewsListState(error = e.localizedMessage ?: "An unexpected error occured")
        }.launchIn(viewModelScope)
    }
}