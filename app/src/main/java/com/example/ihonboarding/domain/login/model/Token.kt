package com.example.ihonboarding.domain.login.model

import kotlinx.serialization.Serializable

@Serializable
data class Token(
    val expiresAt: String,
    val scheme: String = "Bearer",
    val token: String
)