package com.example.ihonboarding.data.home.data_source.cache

import com.example.ihonboarding.data.home.model.News

interface NewsCacheDataSource {
    suspend fun getNewsFromCache(): List<News>
    suspend fun saveNewsToCache(news: List<News>)
}