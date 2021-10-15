package com.example.ihonboarding.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Counter(
    var comment: Int? = null,
    var downvote: Int? = null,
    var upvote: Int? = null,
    var view: Int? = null
)