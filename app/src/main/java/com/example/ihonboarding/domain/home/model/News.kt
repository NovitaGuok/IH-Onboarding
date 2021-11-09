package com.example.ihonboarding.domain.home.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class News(
    val id: Int,

    @SerialName("channel_id")
    val channelId: Int?,

    @SerialName("channel_name")
    val channelName: String? = "",

    val upvote: Int? = 0,

    val downvote: Int? = 0,

    val comment: Int? = 0,

    val view: Int? = 0,

    @SerialName("cover_image")
    val coverImage: String? = "",

    @SerialName("created_at")
    val createdAt: String? = "",

    val nsfw: Boolean? = false,

    val title: String? = "",

    val url: String? = ""
)