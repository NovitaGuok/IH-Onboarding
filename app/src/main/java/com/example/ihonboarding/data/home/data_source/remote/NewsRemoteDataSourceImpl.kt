package com.example.ihonboarding.data.home.data_source.remote

import com.example.ihonboarding.data.home.api.NewsService
import com.example.ihonboarding.data.home.model.NewsList
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsService: NewsService,
    private val authorizations: String
) : NewsRemoteDataSource {
    override suspend fun getNews(): Response<NewsList> = newsService.getAllNews(authorizations)
}