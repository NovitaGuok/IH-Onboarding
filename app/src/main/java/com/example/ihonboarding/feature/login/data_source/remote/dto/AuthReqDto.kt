package com.example.ihonboarding.feature.login.data_source.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class AuthReqDto(
    @SerialName("username")
    val userName: String,

    @SerialName("password")
    val password: String,
)