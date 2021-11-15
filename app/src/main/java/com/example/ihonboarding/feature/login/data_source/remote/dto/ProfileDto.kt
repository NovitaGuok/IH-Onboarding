package com.example.ihonboarding.feature.login.data_source.remote.dto

import kotlinx.serialization.SerialName


data class ProfileDto (
    @SerialName("bio")
    var bio: String,

    @SerialName("name")
    var name: String,

    @SerialName("picture")
    var picture: String,

    @SerialName("username")
    var username: String,

    @SerialName("web")
    var web: String
)