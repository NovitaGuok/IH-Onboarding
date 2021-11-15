package com.example.ihonboarding.feature.login.data_source.remote

import com.example.ihonboarding.feature.login.data_source.remote.dto.TokenDto

interface AuthRemoteDataSource {
    suspend fun login(username: String, password: String): TokenDto
    suspend fun refreshToken(): TokenDto
}