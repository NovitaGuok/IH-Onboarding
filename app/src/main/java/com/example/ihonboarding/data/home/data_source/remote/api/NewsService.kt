package com.example.ihonboarding.data.home.data_source.remote.api

import com.example.ihonboarding.data.home.data_source.remote.dto.NewsListDto
import retrofit2.http.GET
import retrofit2.http.Header

interface NewsService {
    @GET("me/news")
    suspend fun getNews(
        @Header("Authorization") token: String,
//        @Query("token") token: String
    ): NewsListDto
}