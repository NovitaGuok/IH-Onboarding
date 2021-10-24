package com.example.ihonboarding.data.network.model

import com.google.gson.annotations.SerializedName

data class ChannelDto(
    @SerializedName("id")
    var id: Int? = null,
    
    @SerializedName("name")
    var name: String? = null
)