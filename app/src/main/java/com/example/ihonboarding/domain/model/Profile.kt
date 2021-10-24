package com.example.ihonboarding.domain.model

import kotlinx.serialization.Serializable

data class Profile(
    var bio: String? = null,
    var name: String? = null,
    var picture: String? = null,
    var username: String? = null,
    var web: String? = null
)