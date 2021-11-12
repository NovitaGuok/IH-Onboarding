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
    fun getNewsList(): Flow<List<News>> {
        return newsRepository.getNewsList()
    }

//    operator fun invoke(
//        newsOrder: NewsOrder = NewsOrder.CreatedAt(OrderType.Descending)
//    ): Flow<List<News>> =
//        flow {
//            newsRepository.getNewsList().map { news ->
//                when(newsOrder.orderType) {
//                    is OrderType.Descending -> {
//                        when(newsOrder) {
//                            is NewsOrder.CreatedAt -> news.sortedBy { it.createdAt }
//                            is NewsOrder.Title -> news.sortedBy { it.title.lowercase() }
//                        }
//                    }
//                    is OrderType.Ascending -> {
//                        when(newsOrder) {
//                            is NewsOrder.CreatedAt -> news.sortedByDescending { it.createdAt }
//                            is NewsOrder.Title -> news.sortedByDescending { it.title.lowercase() }
//                        }
//                    }
//                }
//            }
//        }
}