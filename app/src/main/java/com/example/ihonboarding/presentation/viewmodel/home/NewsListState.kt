package com.example.ihonboarding.presentation.viewmodel.home

import com.example.ihonboarding.domain.home.model.News
import com.example.ihonboarding.domain.home.util.NewsOrder
import com.example.ihonboarding.domain.home.util.OrderType

data class NewsListState(
    val isLoading: Boolean = false,
    val newsList: List<News> = emptyList(),
    val error: String = "",
    val newsOrder: NewsOrder = NewsOrder.CreatedAt(OrderType.Descending)
)