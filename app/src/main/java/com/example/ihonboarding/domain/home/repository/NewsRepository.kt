package com.example.ihonboarding.domain.home.repository

import com.example.ihonboarding.domain.home.model.News

interface NewsRepository {
    suspend fun getNewsList(): List<News>
}