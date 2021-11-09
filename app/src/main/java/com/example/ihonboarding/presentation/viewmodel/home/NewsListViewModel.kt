package com.example.ihonboarding.presentation.viewmodel.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ihonboarding.domain.home.use_case.GetNewsUseCase
import com.example.ihonboarding.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel
@Inject constructor(
    private val getNewsUseCase: GetNewsUseCase,
) : ViewModel() {
    private val _newsState = mutableStateOf(NewsListState())
    val state: State<NewsListState> = _newsState

    init {
        getNewsList()
    }

    private fun getNewsList() {
        getNewsUseCase().onEach { res ->
            when (res) {
                is Resource.Success -> {
                    _newsState.value = NewsListState(newsList = res.data ?: emptyList())
                    Log.d("TAG", res.toString())
                }
                is Resource.Error -> {
                    _newsState.value =
                        NewsListState(error = res.msg ?: "An unexpected error occured.")
                }
                is Resource.Loading -> {
                    _newsState.value = NewsListState(isLoading = true)

                }
            }
        }.launchIn(viewModelScope)
    }
}