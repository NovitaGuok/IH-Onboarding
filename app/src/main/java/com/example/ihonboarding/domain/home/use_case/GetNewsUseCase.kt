package com.example.ihonboarding.domain.home.use_case

import com.example.ihonboarding.domain.home.model.News
import com.example.ihonboarding.domain.home.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(): Flow<List<News>> {
        return newsRepository.getNewsList()
    }
}