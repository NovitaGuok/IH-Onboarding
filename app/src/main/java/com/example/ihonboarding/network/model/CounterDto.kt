package com.example.ihonboarding.network.model

import com.google.gson.annotations.SerializedName

data class CounterDto (
    @SerializedName("comment")
    var comment: Int? = null,

    @SerializedName("downvote")
    var downvote: Int? = null,

    @SerializedName("upvote")
    var upvote: Int? = null,

    @SerializedName("view")
    var view: Int? = null
)