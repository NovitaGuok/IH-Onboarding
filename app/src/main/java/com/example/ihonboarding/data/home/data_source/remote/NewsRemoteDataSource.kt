package com.example.ihonboarding.data.home.data_source.remote

import com.example.ihonboarding.data.home.model.NewsList
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getNews(): Response<NewsList>
}