package com.example.ihonboarding.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "auth_token")
data class AuthTokenEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null,

    @ColumnInfo(name = "email")
    var email: String? = null,

    @ColumnInfo(name = "token")
    var token: String? = null,
)