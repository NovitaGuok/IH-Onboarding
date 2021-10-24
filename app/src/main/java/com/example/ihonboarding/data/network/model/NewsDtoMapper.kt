package com.example.ihonboarding.network.model

import com.example.ihonboarding.domain.model.News
import com.example.ihonboarding.domain.mapper.DomainMapper

class NewsDtoMapper : DomainMapper<NewsDto, News> {
    override fun mapToDomainModel(model: NewsDto): News {
        return News(
            id = model.id,
            channel = model.channel,
            counter = model.counter,
            cover_image = model.cover_image,
            created_at = model.created_at,
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
            cover_image = domainModel.cover_image,
            created_at = domainModel.created_at,
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