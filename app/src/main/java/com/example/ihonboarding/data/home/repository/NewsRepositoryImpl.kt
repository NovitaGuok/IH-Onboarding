package com.example.ihonboarding.data.home.repository

import android.annotation.SuppressLint
import com.example.ihonboarding.data.home.data_source.cache.NewsCacheDataSource
import com.example.ihonboarding.data.home.data_source.local.NewsLocalDataSource
import com.example.ihonboarding.data.home.data_source.remote.NewsRemoteDataSource
import com.example.ihonboarding.data.home.model.News
import com.example.ihonboarding.data.home.model.NewsList
import com.example.ihonboarding.domain.home.repository.NewsRepository
import com.example.ihonboarding.util.Constants.Companion.TAG
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource,
    private val newsCacheDataSource: NewsCacheDataSource
) : NewsRepository {
    override suspend fun getNews(): List<News> {
        return getNewsFromCache()
    }

    override suspend fun updateNews(): List<News> {
        val newListOfNews: List<News> = getNewsFromApi()

        newsLocalDataSource.clearAll()
        newsLocalDataSource.saveNewsToDb(newListOfNews)
        newsCacheDataSource.saveNewsToCache(newListOfNews)
        return newListOfNews
    }

    @SuppressLint("TimberArgCount")
    suspend fun getNewsFromApi(): List<News> {
        var newsList: List<News> = listOf(News(id = 1, channelId = 1, title = "this is title"))
        try {
            val response: Response<NewsList> = newsRemoteDataSource.getNews()
            val body: NewsList? = response.body()
            if (body != null) {
                newsList = body.news!!
            }
        } catch (e: Exception) {
            Timber.e(TAG, e.message.toString())
        }
        return newsList
    }

    @SuppressLint("TimberArgCount")
    suspend fun getNewsFromDb(): List<News> {
        var newsList: List<News> = emptyList()
        try {
            newsList = newsLocalDataSource.getNewsFromDb()
        } catch (e: Exception) {
            Timber.e(TAG, e.message.toString())
        }
        if (newsList.isNotEmpty()) return newsList
        else {
            newsList = getNewsFromApi()
            newsLocalDataSource.saveNewsToDb(newsList)
        }
        return newsList
    }

    @SuppressLint("TimberArgCount")
    suspend fun getNewsFromCache(): List<News> {
        var newsList: List<News> = emptyList()
        try {
            newsList = newsCacheDataSource.getNewsFromCache()
        } catch (e: Exception) {
            Timber.e(TAG, e.message.toString())
        }
        if (newsList.isNotEmpty()) return newsList
        else {
            newsList = getNewsFromDb()
            newsCacheDataSource.saveNewsToCache(newsList)
        }
        return newsList
    }
}