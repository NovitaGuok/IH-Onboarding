package com.example.ihonboarding.feature.home.data_source.remote

import com.example.ihonboarding.domain.home.model.News
import com.example.ihonboarding.feature.home.data_source.remote.api.NewsService
import com.example.ihonboarding.feature.home.data_source.remote.dto.toSingleNews
import com.example.ihonboarding.feature.login.data_source.local.SessionManager
import javax.inject.Inject

class NewsRemoteDataSourceImpl @Inject constructor(
    private val newsService: NewsService,
    private val sessionManager: SessionManager
) : NewsRemoteDataSource {
    override suspend fun getNewsList(): List<News> {
        var token = sessionManager.getToken()
        return newsService.getNewsList("Bearer $token").data.map { news ->
            news.toSingleNews()
        }
    }
}


