package com.example.ihonboarding.data.network.source

import com.example.ihonboarding.data.network.AuthService
import com.example.ihonboarding.data.network.model.AuthTokenDto
import com.example.ihonboarding.data.network.requests.AuthLoginRequest
import com.example.ihonboarding.domain.model.AuthToken
import com.example.ihonboarding.util.Resources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class AuthTokenRemoteSourceImpl @Inject constructor(private val authServiceApi: AuthService) :
    AuthTokenRemoteSource {
    override suspend fun loginAuthToken(authLoginRequest: AuthLoginRequest): Flow<Response<AuthTokenDto>> =
        flow {
            val result = authServiceApi.login(authLoginRequest)
            emit(result)
        }
}