package com.example.ihonboarding.network.model

import com.google.gson.annotations.SerializedName

data class ChannelDto(
    @SerializedName("id")
    var id: Int? = null,
    
    @SerializedName("name")
    var name: String? = null
)