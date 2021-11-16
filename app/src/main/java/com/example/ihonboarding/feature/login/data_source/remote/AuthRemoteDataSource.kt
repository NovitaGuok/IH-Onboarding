package com.example.ihonboarding.feature.login.data_source.remote

import com.example.ihonboarding.domain.login.model.Token
import com.example.ihonboarding.feature.login.data_source.remote.dto.AuthReqDto
import com.example.ihonboarding.feature.login.data_source.remote.dto.TokenDto

interface AuthRemoteDataSource {
    suspend fun login(authReqDto: AuthReqDto): TokenDto
    suspend fun refreshToken(): TokenDto
}