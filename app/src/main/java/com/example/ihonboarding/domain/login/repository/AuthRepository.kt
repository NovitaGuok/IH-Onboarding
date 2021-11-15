package com.example.ihonboarding.domain.login.repository

import com.example.ihonboarding.domain.login.model.Token

interface AuthRepository {
    suspend fun login(email: String, password: String): Token
    suspend fun refreshToken(): Token
}