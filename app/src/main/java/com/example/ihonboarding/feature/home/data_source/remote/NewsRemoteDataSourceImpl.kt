package com.example.ihonboarding.feature.home.data_source.remote

import com.example.ihonboarding.domain.home.model.News
import com.example.ihonboarding.feature.home.data_source.remote.api.NewsService
import com.example.ihonboarding.feature.home.data_source.remote.dto.toSingleNews
import javax.inject.Inject

class NewsRemoteDataSourceImpl @Inject constructor(
    private val newsService: NewsService,
) : NewsRemoteDataSource {
    override suspend fun getNewsList(): List<News> {
        return newsService.getNewsList("Bearer").data.map { news ->
            news.toSingleNews()
        }
    }
//    override suspend fun getNewsList(): Flow<List<News>> {
//        return flow {
//            newsService.getNewsList("Bearer dGVzdGVyfDIwMjEtMTEtMTBUMTg6MDM6MThafGNmNDg2NzkxOTAzMzk5MzEyZDc0MGJmNGI0YzBmNTBmMTYzYzUzZTZlOGJkYTk3YWViZDc1YWI4MDU1MjhkZGE=")
//                .data.map {
//                    it.toSingleNews()
//                }.asFlow().map {
//                    it
//                }.onCompletion {
//                    Log.d(TAG, "onCompletion")
//                    Log.d(TAG, it.toString())
//                }.collect {
//                    Log.d(TAG, it.toString())
//                }
//        }
//    }
}


