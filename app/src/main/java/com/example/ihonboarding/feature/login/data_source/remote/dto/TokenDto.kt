package com.example.ihonboarding.feature.login.data_source.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenDto(
    @SerialName("expires_at")
    val expiresAt: String,
    @SerialName("scheme")
    val scheme: String = "Bearer",
    @SerialName("token")
    val token: String
)