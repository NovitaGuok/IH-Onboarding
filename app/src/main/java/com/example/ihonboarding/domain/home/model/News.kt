package com.example.ihonboarding.domain.home.model

data class News(
    val id: Int,
    val channelId: Int,
    val channelName: String = "",
    val upvote: Int = 0,
    val downvote: Int = 0,
    val comment: Int = 0,
    val view: Int = 0,
    val coverImage: String = "",
    val createdAt: String = "",
    val nsfw: Boolean = false,
    val title: String = "",
    val url: String = ""
)

