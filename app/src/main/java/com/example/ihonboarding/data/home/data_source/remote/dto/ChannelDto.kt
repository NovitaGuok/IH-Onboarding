package com.example.ihonboarding.data.home.data_source.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChannelDto(
    @SerialName("id")
    val id: Int = 0,

    @SerialName("name")
    val name: String = ""
)