package com.example.ihonboarding.data_source.home.remote.repository

import com.example.ihonboarding.domain.home.model.News

interface NewsRemoteDataSource {
    suspend fun getNewsList(): List<News>
//    suspend fun getNewsList(): Flow<List<News>>
}