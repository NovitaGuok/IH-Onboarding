package com.example.ihonboarding.data.data_source.remote

import com.example.ihonboarding.data.model.NewsList
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getNews(): Response<NewsList>
}