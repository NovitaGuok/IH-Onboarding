package com.example.ihonboarding.domain.home.use_case

import com.example.ihonboarding.domain.home.model.News
import com.example.ihonboarding.domain.home.repository.NewsRepository
import com.example.ihonboarding.domain.home.util.NewsOrder
import com.example.ihonboarding.domain.home.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(): Flow<List<News>> {
        return newsRepository.getNewsList()
    }
}