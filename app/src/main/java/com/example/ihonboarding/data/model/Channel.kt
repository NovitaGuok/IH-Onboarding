package com.example.ihonboarding.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "channel")
data class Channel(
    @PrimaryKey(autoGenerate = true)
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String? = ""
)