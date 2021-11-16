package com.example.ihonboarding.domain.login.repository

import com.example.ihonboarding.domain.login.model.Token
import com.example.ihonboarding.feature.login.data_source.remote.dto.AuthReqDto

interface AuthRepository {
    suspend fun login(username: String, password: String): Token
    suspend fun refreshToken(): Token
    fun isLoggedIn(): Boolean
}