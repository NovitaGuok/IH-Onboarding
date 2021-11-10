package com.example.ihonboarding.domain.home.use_case

import android.util.Log
import com.example.ihonboarding.domain.home.model.News
import com.example.ihonboarding.data_source.home.remote.repository.NewsRemoteDataSource
import com.example.ihonboarding.domain.home.util.NewsOrder
import com.example.ihonboarding.domain.home.util.OrderType
import com.example.ihonboarding.util.Constants.Companion.TAG
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(private val newsRemoteDataSource: NewsRemoteDataSource) {
    operator fun invoke(
        newsOrder: NewsOrder = NewsOrder.CreatedAt(OrderType.Descending)
    ): Flow<List<News>> =
        flow {
            newsRemoteDataSource.getNewsList().asFlow().map {
                it
            }.onCompletion {
                Log.d(TAG, "onCompletion")
                Log.d(TAG, it.toString())
            }.collect {
                Log.d(TAG, it.toString())
            }
        }
}