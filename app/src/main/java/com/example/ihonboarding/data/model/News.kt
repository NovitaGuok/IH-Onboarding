package com.example.ihonboarding.data.model


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

    @Embedded
    @SerialName("channel")
    val channel: Channel?,

    @SerialName("counter")
    val counter: Counter? = Counter(),

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