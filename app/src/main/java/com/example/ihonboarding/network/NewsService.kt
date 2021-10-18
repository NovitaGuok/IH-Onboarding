package com.example.ihonboarding.network

import com.example.ihonboarding.network.model.NewsDto
import com.example.ihonboarding.network.responses.NewsSearchResponses
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NewsService {
    @GET("search")
    suspend fun search(
        @Header("Authorization") token: String,
        @Query("page") page: Int,
        @Query("query") query: String
    ): NewsSearchResponses

    @GET("get")
    suspend fun get(
        @Header("Authorization") token: String,
        @Query("id") id: Int,
    ): NewsDto
}