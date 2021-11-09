package com.example.ihonboarding.presentation.viewmodel.home

import com.example.ihonboarding.domain.home.model.News

data class NewsListState(
    val isLoading: Boolean = false,
    val newsList: List<News> = emptyList(),
    val error: String = ""
)