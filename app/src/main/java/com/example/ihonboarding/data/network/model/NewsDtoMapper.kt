package com.example.ihonboarding.data.network.model

import com.example.ihonboarding.domain.model.News
import com.example.ihonboarding.domain.mapper.DomainMapper

class NewsDtoMapper : DomainMapper<NewsDto, News> {
    override fun mapToDomainModel(model: NewsDto): News {
        return News(
            id = model.id,
            channel = model.channel,
            counter = model.counter,
            coverImage = model.coverImage,
            createdAt = model.createdAt,
            nsfw = model.nsfw,
            title = model.title,
            url = model.url
        )
    }

    override fun mapFromDomainModel(domainModel: News): NewsDto {
        return NewsDto(
            id = domainModel.id,
            channel = domainModel.channel,
            counter = domainModel.counter,
            coverImage = domainModel.coverImage,
            createdAt = domainModel.createdAt,
            nsfw = domainModel.nsfw,
            title = domainModel.title,
            url = domainModel.url
        )
    }

    fun toDomainList(initial: List<NewsDto>): List<News> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<News>): List<NewsDto> {
        return initial.map { mapFromDomainModel(it) }
    }
}