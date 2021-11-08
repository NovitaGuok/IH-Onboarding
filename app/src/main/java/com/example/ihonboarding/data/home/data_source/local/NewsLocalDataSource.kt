package com.example.ihonboarding.data.home.data_source.local

import com.example.ihonboarding.data.home.model.News

interface NewsLocalDataSource {
    suspend fun getNewsFromDb(): List<News>
    suspend fun saveNewsToDb(news: List<News>)
    suspend fun clearAll()
}