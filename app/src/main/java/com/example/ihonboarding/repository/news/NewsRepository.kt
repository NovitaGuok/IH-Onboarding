package com.example.ihonboarding.repository

import com.example.ihonboarding.domain.model.News

interface NewsRepository {
    suspend fun search(token: String, page: Int, query: String): List<News>
    suspend fun get(token: String, id: Int): News
}