package com.example.ihonboarding.data.data_source.remote

import com.example.ihonboarding.data.api.NewsService
import com.example.ihonboarding.data.model.NewsList
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsService: NewsService,
    private val authorizations: String
) : NewsRemoteDataSource {
    override suspend fun getNews(): Response<NewsList> = newsService.getAllNews(authorizations)
}