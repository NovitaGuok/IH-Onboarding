package com.example.ihonboarding.data.home.repository

import com.example.ihonboarding.data.home.data_source.local.dao.NewsDao
import com.example.ihonboarding.data.home.data_source.remote.api.NewsService
import com.example.ihonboarding.data.home.data_source.remote.dto.toSingleNews
import com.example.ihonboarding.domain.home.model.News
import com.example.ihonboarding.domain.home.model.NewsEntity
import com.example.ihonboarding.domain.home.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsService: NewsService,
    private val dao: NewsDao
) : NewsRepository {
    // Remote
    override suspend fun getNewsList(): List<News> {
        return newsService.getNews("Bearer dGVzdGVyfDIwMjEtMTEtMDlUMjE6MzQ6NTJafDM2M2JhM2U5YTRjYTZkZjExYzY4MThlYTVhMjIyYTZjM2M1ZGZmNjI2MzBiOTNjZDNiYWYwZGI4M2Q1ZTc1YjQ=")
            .data.map {
                it.toSingleNews()
            }
    }

    // Local
    override fun getLocalNewsList(): Flow<List<NewsEntity>> {
        return dao.getNewsList()
    }

    override suspend fun insertLocalNews(news: NewsEntity) {
        dao.insertNews(news)
    }

    override suspend fun deleteNews(news: NewsEntity) {
        dao.deleteNews(news)
    }
}