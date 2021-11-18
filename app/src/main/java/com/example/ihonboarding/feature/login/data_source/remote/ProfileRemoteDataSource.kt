package com.example.ihonboarding.feature.login.data_source.remote

import com.example.ihonboarding.feature.login.data_source.remote.dto.ProfileDto
import retrofit2.Response

interface ProfileRemoteDataSource {
    suspend fun getProfile(): Response<ProfileDto>
}