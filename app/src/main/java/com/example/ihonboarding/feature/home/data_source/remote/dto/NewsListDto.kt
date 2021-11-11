package com.example.ihonboarding.feature.home.data_source.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsListDto(
    @SerialName("data")
    val data: List<NewsDto>
)