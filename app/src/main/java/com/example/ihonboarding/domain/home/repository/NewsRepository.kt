package com.example.ihonboarding.domain.home.repository

import com.example.ihonboarding.domain.home.model.News
import com.example.ihonboarding.domain.home.model.NewsEntity
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    // Remote
    suspend fun getNewsList(): List<News>

    // Local
    fun getLocalNewsList(): Flow<List<NewsEntity>>
    suspend fun insertLocalNews(news: NewsEntity)
    suspend fun deleteNews(news: NewsEntity)
}