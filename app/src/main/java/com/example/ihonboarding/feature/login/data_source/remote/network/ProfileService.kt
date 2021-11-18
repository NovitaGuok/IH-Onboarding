package com.example.ihonboarding.feature.login.data_source.remote.network

import com.example.ihonboarding.feature.login.data_source.remote.dto.ProfileDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ProfileService {
    @GET("me/profile")
    suspend fun getProfile(
        @Header("Authorization") token: String,
    ): Response<ProfileDto>
}