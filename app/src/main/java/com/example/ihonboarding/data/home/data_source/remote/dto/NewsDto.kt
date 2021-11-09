package com.example.ihonboarding.data.home.data_source.remote.dto


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ihonboarding.domain.home.model.News
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsDto(
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

fun NewsDto.toSingleNews(): News {
    return News(
        id = id,
        channelId = channelId,
        channelName = channelName,
        upvote = upvote,
        downvote = downvote,
        comment = comment,
        view = view,
        coverImage = coverImage,
        createdAt = createdAt,
        nsfw = nsfw,
        title = title,
        url = url,
    )
}