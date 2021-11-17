package com.example.ihonboarding.feature.home.repository

import android.util.Log
import com.example.ihonboarding.domain.home.model.News
import com.example.ihonboarding.domain.home.repository.NewsRepository
import com.example.ihonboarding.feature.home.data_source.local.NewsLocalDataSource
import com.example.ihonboarding.feature.home.data_source.remote.NewsRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource,
) : NewsRepository {
    override fun getNewsList(): Flow<List<News>> {
        return flow {
            val newData = newsRemoteDataSource.getNewsList()
            Log.d("newData", newData.toString())
            saveToLocalDb(newData)
            emitAll(newsLocalDataSource.getLocalNewsList().map { news -> news })
        }.catch { e ->
            val previousData = newsLocalDataSource.getLocalNewsList().map { news -> news }
            Log.d("previousData" + e.localizedMessage.toString(), previousData.first().toString())
            emitAll(previousData)
        }.flowOn(Dispatchers.IO)
    }

    private suspend fun saveToLocalDb(news: List<News>) {
        newsLocalDataSource.insertLocalNews(news)
    }
}