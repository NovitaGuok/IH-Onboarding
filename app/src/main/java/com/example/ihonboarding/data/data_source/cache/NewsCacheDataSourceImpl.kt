package com.example.ihonboarding.data.data_source.cache

import com.example.ihonboarding.data.model.News

class NewsCacheDataSourceImpl : NewsCacheDataSource {

    private var newsList = ArrayList<News>()

    override suspend fun getNewsFromCache(): List<News> {
        return newsList
    }

    override suspend fun saveNewsToCache(news: List<News>) {
        newsList.clear()
        newsList = ArrayList(news)
    }
}