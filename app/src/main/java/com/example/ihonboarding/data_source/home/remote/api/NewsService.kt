package com.example.ihonboarding.data_source.home.remote.api

import com.example.ihonboarding.data_source.home.remote.dto.NewsListDto
import retrofit2.http.GET
import retrofit2.http.Header

interface NewsService {
    @GET("me/news")
    suspend fun getNewsList(
        @Header("Authorization") token: String,
    ): NewsListDto
}