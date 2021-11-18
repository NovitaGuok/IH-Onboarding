package com.example.ihonboarding.feature.login.data_source.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthReqDto(
    @SerialName("username")
    val username: String,
    @SerialName("password")
    val password: String
)