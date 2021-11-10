package com.example.ihonboarding.data_source.home.remote.repository

import com.example.ihonboarding.data_source.home.remote.api.NewsService
import com.example.ihonboarding.data_source.home.remote.dto.toSingleNews
import com.example.ihonboarding.domain.home.model.News
import javax.inject.Inject

class NewsRemoteDataSourceImpl @Inject constructor(
    private val newsService: NewsService,
) : NewsRemoteDataSource {
    override suspend fun getNewsList(): List<News> {
        return newsService.getNewsList("Bearer dGVzdGVyfDIwMjEtMTEtMTBUMTg6MDM6MThafGNmNDg2NzkxOTAzMzk5MzEyZDc0MGJmNGI0YzBmNTBmMTYzYzUzZTZlOGJkYTk3YWViZDc1YWI4MDU1MjhkZGE=")
            .data.map {
                it.toSingleNews()
            }
    }
}