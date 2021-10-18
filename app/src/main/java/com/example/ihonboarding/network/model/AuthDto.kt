package com.example.ihonboarding.network.model

import com.google.gson.annotations.SerializedName

data class AuthDto (
    @SerializedName("token")
    var token: String? = null,

    @SerializedName("expires_at")
    var expires_at: String? = null,

    @SerializedName("scheme")
    var scheme: String? = null
)