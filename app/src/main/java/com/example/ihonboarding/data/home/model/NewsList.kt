package com.example.ihonboarding.data.home.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsList(
    @SerialName("results")
    val news: List<News>? = listOf()
)