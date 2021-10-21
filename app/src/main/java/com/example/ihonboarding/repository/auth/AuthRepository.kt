package com.example.ihonboarding.repository.auth

import com.example.ihonboarding.data.network.requests.AuthLoginRequest
import com.example.ihonboarding.domain.model.AuthToken
import com.example.ihonboarding.util.Resources
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(authLoginRequest: AuthLoginRequest): Flow<Resources<AuthToken>>
    suspend fun checkPrevAuthUser() : Flow<Resources<AuthToken>>
}