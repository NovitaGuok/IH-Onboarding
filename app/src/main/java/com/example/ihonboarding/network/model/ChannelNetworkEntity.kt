package com.example.ihonboarding.network.model

import com.google.gson.annotations.SerializedName

class ChannelNetworkEntity(
    @SerializedName("id")
    var id: Int? = null,
    
    @SerializedName("name")
    var name: String? = null
)