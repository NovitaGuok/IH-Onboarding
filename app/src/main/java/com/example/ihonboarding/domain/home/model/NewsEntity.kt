package com.example.ihonboarding.domain.home.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewsEntity(
    @PrimaryKey(autoGenerate = true)
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