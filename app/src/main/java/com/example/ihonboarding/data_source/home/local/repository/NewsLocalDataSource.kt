package com.example.ihonboarding.data_source.home.local.repository

import com.example.ihonboarding.domain.home.model.News
import kotlinx.coroutines.flow.Flow

interface NewsLocalDataSource {
    fun getLocalNewsList(): Flow<List<News>>
    suspend fun insertLocalNews(News: News)
    suspend fun deleteLocalNews(News: News)
}