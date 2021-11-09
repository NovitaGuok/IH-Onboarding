package com.example.ihonboarding.domain.home.repository

import com.example.ihonboarding.data.home.data_source.remote.dto.NewsDto

interface NewsRepository {
    suspend fun getNewsList(): List<NewsDto>?
}