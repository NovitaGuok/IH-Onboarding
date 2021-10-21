package com.example.ihonboarding.data.network.source

import com.example.ihonboarding.data.network.model.AuthTokenDto
import com.example.ihonboarding.data.network.requests.AuthLoginRequest
import retrofit2.Response
import kotlinx.coroutines.flow.Flow

interface AuthTokenRemoteSource {
    suspend fun loginAuthToken(authLoginRequest: AuthLoginRequest): Flow<Response<AuthTokenDto>>
}