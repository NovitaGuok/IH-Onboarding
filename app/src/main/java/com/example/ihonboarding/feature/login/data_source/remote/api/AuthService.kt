package com.example.ihonboarding.feature.login.data_source.remote.api

import com.example.ihonboarding.feature.login.data_source.remote.dto.AuthReqDto
import com.example.ihonboarding.feature.login.data_source.remote.dto.TokenDto
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthService {
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Body authRequestDto: AuthReqDto
    ): Response<TokenDto>

    @GET("auth/token")
    suspend fun refreshToken(): Response<TokenDto>

    @POST("logout")
    suspend fun logout(): ResponseBody
}