package com.example.ihonboarding.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Channel(
    var id: Int? = null,
    var name: String? = null
)