package com.example.ihonboarding.repository

import com.example.ihonboarding.domain.model.News
import com.example.ihonboarding.network.NewsService
import com.example.ihonboarding.network.model.NewsDtoMapper

class NewsRepositoryImpl(private val newsService: NewsService, private val mapper: NewsDtoMapper) :
    NewsRepository {
    override suspend fun search(token: String, page: Int, query: String): List<News> {
        return mapper.toDomainList(newsService.search(token, page, query).news)
    }

    override suspend fun get(token: String, id: Int): News {
        return mapper.mapToDomainModel(newsService.get(token, id))
    }

}