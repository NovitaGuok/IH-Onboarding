package com.example.ihonboarding.domain.home.repository

import com.example.ihonboarding.data.home.model.News

interface NewsRepository {
    suspend fun getNews(): List<News>?
    suspend fun updateNews(): List<News>?
}