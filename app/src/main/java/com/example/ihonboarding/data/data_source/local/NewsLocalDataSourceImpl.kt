package com.example.ihonboarding.data.data_source.local

import com.example.ihonboarding.data.dao.NewsDao
import com.example.ihonboarding.data.model.News
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