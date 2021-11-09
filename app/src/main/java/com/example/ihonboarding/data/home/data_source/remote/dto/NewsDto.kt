package com.example.ihonboarding.data.home.data_source.remote.dto


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ihonboarding.domain.home.model.News
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsDto(
    @SerialName("id")
    val id: Int,

    @SerialName("channel")
    val channel: ChannelDto,

    @SerialName("counter")
    val counter: CounterDto,

    @SerialName("cover_image")
    val coverImage: String = "",

    @SerialName("created_at")
    val createdAt: String = "",

    @SerialName("nfsw")
    val nsfw: Boolean = false,

    @SerialName("title")
    val title: String = "",

    @SerialName("url")
    val url: String = ""
)

fun NewsDto.toSingleNews(): News {
    return News(
        id = id,
        channelId = channel.id,
        channelName = channel.name,
        upvote = counter.upvote,
        downvote = counter.downvote,
        comment = counter.comment,
        view = counter.view,
        coverImage = coverImage,
        createdAt = createdAt,
        nsfw = nsfw,
        title = title,
        url = url,
    )
}