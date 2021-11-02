package com.example.ihonboarding.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Counter(
    @SerialName("comment")
    val comment: Int? = 0,

    @SerialName("downvote")
    val downvote: Int? = 0,

    @SerialName("upvote")
    val upvote: Int? = 0,

    @SerialName("view")
    val view: Int? = 0
)