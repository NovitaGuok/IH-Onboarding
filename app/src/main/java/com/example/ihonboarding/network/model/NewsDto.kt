package com.example.ihonboarding.network.model

import com.example.ihonboarding.domain.model.Channel
import com.example.ihonboarding.domain.model.Counter
import com.google.gson.annotations.SerializedName

data class NewsDto (
    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("channel")
    val channel: Channel? = null,

    @SerializedName("counter")
    val counter: Counter? = null,

    @SerializedName("cover_image")
    val cover_image: String? = null,

    @SerializedName("created_at")
    val created_at: String? = null,

    @SerializedName("nsfw")
    val nsfw: Boolean? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("url")
    val url: String? = null
)