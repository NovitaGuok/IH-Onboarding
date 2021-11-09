package com.example.ihonboarding.data.home.repository

import com.example.ihonboarding.data.home.data_source.remote.api.NewsService
import com.example.ihonboarding.data.home.data_source.remote.dto.NewsDto
import com.example.ihonboarding.data.home.data_source.remote.dto.NewsListDto
import com.example.ihonboarding.data.home.data_source.remote.dto.toSingleNews
import com.example.ihonboarding.domain.home.model.News
import com.example.ihonboarding.domain.home.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsService: NewsService,
) : NewsRepository {
    override suspend fun getNewsList(): List<News> {
        return newsService.getNews("Bearer dGVzdGVyfDIwMjEtMTEtMDlUMTI6MDU6NTlafDU0OGVhNmQ3MGYzYWZlNDIyZjcxZWRmMjU5NzhiMWQyMTdkYzM5M2NlYmU1MjA4MDMwMDliZWE3NmY2MTRiZTg=")
            .data.map {
                it.toSingleNews()
            }
    }
//    override suspend fun getNews(): List<NewsDto>? {
//        return getNewsFromCache()
//    }
//
//    override suspend fun updateNews(): List<NewsDto>? {
//        val newListOfNews: List<NewsDto>? = getNewsFromApi()
//
//        newsLocalDataSource.clearAll()
//        newsLocalDataSource.saveNewsToDb(newListOfNews)
//        newsCacheDataSource.saveNewsToCache(newListOfNews)
//        return newListOfNews
//    }
//
//    @SuppressLint("TimberArgCount")
//    suspend fun getNewsFromApi(): List<NewsDto> {
//        lateinit var newsList: List<NewsDto>
//        try {
//            val response: Response<NewsList> = newsRemoteDataSource.getNews()
//            val body: NewsList? = response.body()
//            if (body != null) {
//                newsList = body.news!!
//            }
//        } catch (e: Exception) {
//            Timber.e(TAG, e.message.toString())
//        }
//        return newsList
//    }
//
//    @SuppressLint("TimberArgCount")
//    suspend fun getNewsFromDb(): List<News> {
//        lateinit var newsList: List<News>
//        try {
//            newsList = newsLocalDataSource.getNewsFromDb()
//        } catch (e: Exception) {
//            Timber.e(TAG, e.message.toString())
//        }
//        if (newsList.isNotEmpty()) return newsList
//        else {
//            newsList = getNewsFromApi()
//            newsLocalDataSource.saveNewsToDb(newsList)
//        }
//        return newsList
//    }
//
//    @SuppressLint("TimberArgCount")
//    suspend fun getNewsFromCache(): List<News> {
//        lateinit var newsList: List<News>
//        try {
//            newsList = newsCacheDataSource.getNewsFromCache()
//        } catch (e: Exception) {
//            Timber.e(TAG, e.message.toString())
//        }
//        if (newsList.isNotEmpty()) return newsList
//        else {
//            newsList = getNewsFromDb()
//            newsCacheDataSource.saveNewsToCache(newsList)
//        }
//        return newsList
//    }
}