package com.example.ihonboarding.data.data_source.cache

import com.example.ihonboarding.data.model.News

interface NewsCacheDataSource {
    suspend fun getNewsFromCache(): List<News>
    suspend fun saveNewsToCache(news: List<News>)
}