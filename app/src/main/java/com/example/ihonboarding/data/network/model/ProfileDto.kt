package com.example.ihonboarding.data.network.model

import com.google.gson.annotations.SerializedName


data class ProfileDto (
    @SerializedName("bio")
    var bio: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("picture")
    var picture: String? = null,

    @SerializedName("username")
    var username: String? = null,

    @SerializedName("web")
    var web: String? = null
)