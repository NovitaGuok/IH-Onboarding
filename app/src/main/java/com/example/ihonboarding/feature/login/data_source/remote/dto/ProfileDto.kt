package com.example.ihonboarding.feature.login.data_source.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileDto(
    @SerialName("bio")
    val bio: String = "",
    @SerialName("name")
    val name: String = "",
    @SerialName("picture")
    val picture: String = "",
    @SerialName("username")
    val username: String = "",
    @SerialName("web")
    val web: String = ""
)