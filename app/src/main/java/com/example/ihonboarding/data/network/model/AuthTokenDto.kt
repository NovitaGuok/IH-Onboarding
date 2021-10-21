package com.example.ihonboarding.data.network.model

import com.google.gson.annotations.SerializedName

data class AuthTokenDto(
    @SerializedName("token")
    val token: String? = null,

    @SerializedName("error")
    val error: String? = null
)