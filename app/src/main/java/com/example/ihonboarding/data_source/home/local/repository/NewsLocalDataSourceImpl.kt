package com.example.ihonboarding.data_source.home.local.repository

import com.example.ihonboarding.data_source.home.local.dao.NewsDao
import com.example.ihonboarding.domain.home.model.News
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class NewsLocalDataSourceImpl @Inject constructor(
    private val newsDao: NewsDao
) : NewsLocalDataSource {
    override fun getLocalNewsList(): Flow<List<News>>  {
        return newsDao.getLocalNewsList()
    }

    override suspend fun insertLocalNews(News: News) {
        newsDao.insertLocalNews(News)
    }

    override suspend fun deleteLocalNews(News: News) {
        newsDao.deleteLocalNews(News)
    }
}