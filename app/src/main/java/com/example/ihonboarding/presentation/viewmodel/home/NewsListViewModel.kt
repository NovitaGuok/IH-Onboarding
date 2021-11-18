package com.example.ihonboarding.presentation.viewmodel.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ihonboarding.domain.home.model.News
import com.example.ihonboarding.domain.home.use_case.GetNewsUseCase
import com.example.ihonboarding.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel
@Inject constructor(
    private val getNewsUseCase: GetNewsUseCase,
) : ViewModel() {
    private val _newsState: MutableState<Resource<List<News>>> = mutableStateOf(Resource.Init())
    val newsState: State<Resource<List<News>>> = _newsState

    init {
        getNewsList()
    }

    private fun getNewsList() {
        _newsState.value = Resource.Loading()
        getNewsUseCase.invoke().onEach { res ->
            _newsState.value = Resource.Success(data = res)
            Log.d("viewModel", res.toString())
        }.catch { e ->
            _newsState.value = Resource.Error(e.localizedMessage.toString())
        }.launchIn(viewModelScope)
    }
}

