package com.example.ihonboarding.feature.home.repository

import com.example.ihonboarding.domain.home.model.News
import com.example.ihonboarding.domain.home.repository.NewsRepository
import com.example.ihonboarding.feature.home.data_source.local.NewsLocalDataSource
import com.example.ihonboarding.feature.home.data_source.remote.NewsRemoteDataSource
import com.example.ihonboarding.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource,
) : NewsRepository {
    override suspend fun getNewsList(): Flow<List<News>> {
        return flow {
            val newsList = newsRemoteDataSource.getNewsList()
            emit(newsList)
            saveToLocalDb()
            emitAll(newsLocalDataSource.getLocalNewsList().map { news -> news })
        }
    }

    private suspend fun saveToLocalDb() {
        val remoteNewsList: List<News> = newsRemoteDataSource.getNewsList()
        remoteNewsList.forEach {
            newsLocalDataSource.insertLocalNews(it)
        }
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