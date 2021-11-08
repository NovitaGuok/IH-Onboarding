package com.example.ihonboarding.domain.home.use_case

import com.example.ihonboarding.data.home.model.News
import com.example.ihonboarding.domain.home.repository.NewsRepository
import javax.inject.Inject

class UpdateNewsUseCase @Inject constructor(private val newsRepository: NewsRepository) {
    suspend fun execute(): List<News>? = newsRepository.updateNews()
}