package com.example.ihonboarding.feature.home.repository

import android.util.Log
import com.example.ihonboarding.domain.home.model.News
import com.example.ihonboarding.domain.home.repository.NewsRepository
import com.example.ihonboarding.feature.home.data_source.local.NewsLocalDataSource
import com.example.ihonboarding.feature.home.data_source.remote.NewsRemoteDataSource
import com.example.ihonboarding.util.Resource
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
            emit(newData)
            Log.d("newData", newData.toString())
            saveToLocalDb()
            emitAll(newsLocalDataSource.getLocalNewsList().map { news -> news })
        }.catch {
            val previousData = newsLocalDataSource.getLocalNewsList().first()
            emit(previousData)
        }.flowOn(Dispatchers.IO)
    }


    private suspend fun saveToLocalDb() {
        val remoteNewsList: List<News> = newsRemoteDataSource.getNewsList()
        newsLocalDataSource.insertLocalNews(remoteNewsList)

    }

//    override suspend fun getNewsList(): Flow<List<News>> {
//        return newsRemoteDataSource.getNewsList().map {
//            it
//        }.onEach {
//            it.forEach { news ->
//                Log.d("newsRepo", news.toString())
//                newsLocalDataSource.insertLocalNews(news)
//            }
//        }
//    }
}