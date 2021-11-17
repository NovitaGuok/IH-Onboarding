package com.example.ihonboarding.feature.login.data_source.remote.network

import com.example.ihonboarding.feature.login.data_source.remote.dto.AuthReqDto
import com.example.ihonboarding.feature.login.data_source.remote.dto.ProfileDto
import com.example.ihonboarding.feature.login.data_source.remote.dto.TokenDto
import com.example.ihonboarding.feature.login.data_source.remote.util.TokenDtoMapper
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthService {
    @POST("auth/login")
    suspend fun login(
        @Body req: AuthReqDto
    ): Response<TokenDto>

    @GET("auth/token")
    suspend fun refreshToken(): Response<TokenDto>

    @GET("me/profile")
    suspend fun getProfile(): Response<ProfileDto>
}