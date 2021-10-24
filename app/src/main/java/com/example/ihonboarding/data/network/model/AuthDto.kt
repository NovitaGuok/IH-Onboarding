package com.example.ihonboarding.data.network.model

import com.google.gson.annotations.SerializedName

data class AuthDto (
    @SerializedName("token")
    var token: String? = null,

    @SerializedName("expiresAt")
    var expiresAt: String? = null,

    @SerializedName("scheme")
    var scheme: String? = null
)