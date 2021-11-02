package com.example.ihonboarding.domain.use_case

import com.example.ihonboarding.data.model.News
import com.example.ihonboarding.domain.repository.NewsRepository

class UpdateNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(): List<News>? = newsRepository.updateNews()
}