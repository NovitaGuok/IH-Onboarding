package com.example.ihonboarding.feature.login.data_source.remote.dto

import com.example.ihonboarding.domain.login.model.Token
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenDto(
    @SerialName("token")
    val token: String,

    @SerialName("scheme")
    val scheme: String = "Bearer",

    @SerialName("expiresAt")
    val expires_at: String
)

fun TokenDto.toModel(): Token {
    return Token(
        token = token,
        expiresAt = expires_at
    )
}