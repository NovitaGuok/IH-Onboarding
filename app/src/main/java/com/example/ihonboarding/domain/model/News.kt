package com.example.ihonboarding.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class News(
    var id: Int? = null,
    var channel: Channel? = null,
    var counter: Counter? = null,
    var cover_image: String? = null,
    var created_at: String? = null,
    var nsfw: Boolean? = null,
    var title: String? = null,
    var url: String? = null
)