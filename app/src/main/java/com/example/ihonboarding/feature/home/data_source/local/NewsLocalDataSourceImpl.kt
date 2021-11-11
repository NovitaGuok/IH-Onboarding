package com.example.ihonboarding.feature.home.data_source.local

import com.example.ihonboarding.domain.home.model.News
import com.example.ihonboarding.feature.home.data_source.local.dao.NewsDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsLocalDataSourceImpl @Inject constructor(
    private val newsDao: NewsDao
) : NewsLocalDataSource {
    override fun getLocalNewsList(): Flow<List<News>> {
        return newsDao.getLocalNewsList()
    }

    override suspend fun insertLocalNews(news: News) {
        newsDao.insertLocalNews(news)
    }
}