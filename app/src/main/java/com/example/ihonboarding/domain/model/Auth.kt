package com.example.ihonboarding.domain.model

//@Seriali
data class Auth(
    val expires_at: String,
    val scheme: String,
    val token: String
)