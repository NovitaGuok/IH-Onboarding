package com.example.ihonboarding.network.responses

import com.example.ihonboarding.network.model.NewsDto
import com.google.gson.annotations.SerializedName

data class NewsSearchResponses(
    @SerializedName("count")
    val count: Int,

    @SerializedName("results")
    var news: List<NewsDto>
)