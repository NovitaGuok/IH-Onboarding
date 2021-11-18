package com.example.ihonboarding.feature.login.data_source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ihonboarding.domain.login.model.Profile

@Entity(tableName = "profile")
data class ProfileEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "username")
    val username: String = "",
    @ColumnInfo(name = "bio")
    val bio: String = "",
    @ColumnInfo(name = "name")
    val name: String = "",
    @ColumnInfo(name = "picture")
    val picture: String = "",
    @ColumnInfo(name = "web")
    val web: String = ""
)

fun ProfileEntity.toModel() = Profile(
    username = username,
    bio = bio,
    name = name,
    picture = picture,
    web = web
)