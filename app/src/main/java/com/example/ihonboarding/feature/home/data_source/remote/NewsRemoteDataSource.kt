package com.example.ihonboarding.feature.home.data_source.remote

import com.example.ihonboarding.domain.home.model.News
import kotlinx.coroutines.flow.Flow

interface NewsRemoteDataSource {
    suspend fun getNewsList(): List<News>
}