package com.example.ihonboarding.domain.model

import kotlinx.serialization.Serializable

data class News(
    var id: Int? = null,
    var channel: Channel? = null,
    var counter: Counter? = null,
    var coverImage: String? = null,
    var createdAt: String? = null,
    var nsfw: Boolean? = null,
    var title: String? = null,
    var url: String? = null
)