package com.example.ihonboarding.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthTokenDto(
    @SerialName("token")
    val token: String? = null,

    @SerialName("error")
    val error: String? = null
)