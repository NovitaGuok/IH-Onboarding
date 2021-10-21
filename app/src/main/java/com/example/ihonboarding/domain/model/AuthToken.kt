package com.example.ihonboarding.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class AuthToken(
    val id: Int? = null,
    val token: String? = null,
    val expires_at: String? = null,
    val scheme: String = "Bearer",
    val error: String? = null,
    val errorResponse: StateResponse? = null
)

@Serializable
data class StateResponse(
    val message: String?,
    val errorResponseType: ResponseType
)

@Serializable
sealed class ResponseType {
    @Serializable
    object Toast : ResponseType()

    @Serializable
    object Dialog : ResponseType()

    @Serializable
    object None : ResponseType()
}