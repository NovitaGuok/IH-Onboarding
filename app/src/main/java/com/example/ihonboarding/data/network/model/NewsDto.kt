package com.example.ihonboarding.network.model

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

    @SerializedName("cover_image")
    var cover_image: String? = null,

    @SerializedName("created_at")
    var created_at: String? = null,

    @SerializedName("nsfw")
    var nsfw: Boolean? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("url")
    var url: String? = null
)