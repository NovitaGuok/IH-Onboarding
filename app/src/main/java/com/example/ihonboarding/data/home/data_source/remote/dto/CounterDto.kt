package com.example.ihonboarding.data.home.data_source.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CounterDto(
    @SerialName("comment")
    val comment: Int = 0,

    @SerialName("view")
    val view: Int = 0,

    @SerialName("upvote")
    val upvote: Int = 0,

    @SerialName("downvote")
    val downvote: Int = 0,
)