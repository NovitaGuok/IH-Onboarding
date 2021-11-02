package com.example.ihonboarding.data.api

import com.example.ihonboarding.data.model.NewsList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("me/news")
    suspend fun getAllNews(
        @Query("authorizations") authorizations: String
    ): Response<NewsList>
}