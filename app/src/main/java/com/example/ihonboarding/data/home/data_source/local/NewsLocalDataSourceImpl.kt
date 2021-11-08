package com.example.ihonboarding.data.home.data_source.local

import com.example.ihonboarding.data.home.dao.NewsDao
import com.example.ihonboarding.data.home.model.News
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsLocalDataSourceImpl(private val newsDao: NewsDao) : NewsLocalDataSource{
    override suspend fun getNewsFromDb(): List<News> {
        return newsDao.getNews()
    }

    override suspend fun saveNewsToDb(news: List<News>) {
        CoroutineScope(Dispatchers.IO).launch {
            newsDao.saveNews(news)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            newsDao.deleteAllNews()
        }
    }
}