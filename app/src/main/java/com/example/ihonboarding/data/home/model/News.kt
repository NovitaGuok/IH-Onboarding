package com.example.ihonboarding.data.home.model


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "news")
data class News(
    @PrimaryKey(autoGenerate = true)
    @SerialName("id")
    val id: Int,

    @SerialName("channelId")
    val channelId: Int?,

    @SerialName("channelName")
    val channelName: String? = "",

    @SerialName("upvote")
    val upvote: Int? = 0,

    @SerialName("downvote")
    val downvote: Int? = 0,

    @SerialName("comment")
    val comment: Int? = 0,

    @SerialName("view")
    val view: Int? = 0,

    @SerialName("cover_image")
    val coverImage: String? = "",

    @SerialName("created_at")
    val createdAt: String? = "",

    @SerialName("nsfw")
    val nsfw: Boolean? = false,

    @SerialName("title")
    val title: String? = "",

    @SerialName("url")
    val url: String? = ""
)