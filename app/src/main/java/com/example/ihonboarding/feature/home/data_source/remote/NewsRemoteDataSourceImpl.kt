package com.example.ihonboarding.feature.home.data_source.remote

import com.example.ihonboarding.domain.home.model.News
import com.example.ihonboarding.feature.home.data_source.remote.api.NewsService
import com.example.ihonboarding.feature.home.data_source.remote.dto.toSingleNews
import javax.inject.Inject

class NewsRemoteDataSourceImpl @Inject constructor(
    private val newsService: NewsService,
) : NewsRemoteDataSource {
    override suspend fun getNewsList(): List<News> {
        return newsService.getNewsList("Bearer").data.map { news ->
            news.toSingleNews()
        }
    }
}


