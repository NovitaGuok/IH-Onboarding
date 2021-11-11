package com.example.ihonboarding.feature.home.data_source.local

import com.example.ihonboarding.domain.home.model.News
import kotlinx.coroutines.flow.Flow

interface NewsLocalDataSource {
    fun getLocalNewsList(): Flow<List<News>>
    suspend fun insertLocalNews(news: News)
}