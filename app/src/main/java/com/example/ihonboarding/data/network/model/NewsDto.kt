package com.example.ihonboarding.data.network.model

import com.example.ihonboarding.domain.model.Channel
import com.example.ihonboarding.domain.model.Counter
import com.google.gson.annotations.SerializedName

data class NewsDto (
    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("channel")
    var channel: Channel? = null,

    @SerializedName("counter")
    var counter: Counter? = null,

    @SerializedName("coverImage")
    var coverImage: String? = null,

    @SerializedName("createdAt")
    var createdAt: String? = null,

    @SerializedName("nsfw")
    var nsfw: Boolean? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("url")
    var url: String? = null
)