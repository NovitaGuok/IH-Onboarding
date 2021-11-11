package com.example.ihonboarding.domain.home.repository

import com.example.ihonboarding.domain.home.model.News
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNewsList(): Flow<List<News>>
}