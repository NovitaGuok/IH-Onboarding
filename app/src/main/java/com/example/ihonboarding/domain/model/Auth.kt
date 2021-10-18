package com.example.ihonboarding.domain.model

import kotlinx.serialization.*

@Serializable
data class Auth(
    var token: String,
    var expires_at: String,
    var scheme: String
)