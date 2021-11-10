package com.example.ihonboarding.data_source.home.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsListDto(
    @SerialName("data")
    val data: List<NewsDto>
)