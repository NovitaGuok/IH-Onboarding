package com.example.ihonboarding.data.home.api

import com.example.ihonboarding.data.home.model.NewsList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("me/news")
    suspend fun getAllNews(
        @Query("authorizations") authorizations: String
    ): Response<NewsList>
}