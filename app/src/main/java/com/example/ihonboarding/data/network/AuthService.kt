package com.example.ihonboarding.data.network

import com.example.ihonboarding.data.network.model.AuthTokenDto
import com.example.ihonboarding.data.network.requests.AuthLoginRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Body loginRequest: AuthLoginRequest
    ): Response<AuthTokenDto>
}