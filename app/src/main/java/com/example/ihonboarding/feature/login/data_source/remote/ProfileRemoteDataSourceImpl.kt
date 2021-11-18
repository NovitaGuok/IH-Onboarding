package com.example.ihonboarding.feature.login.data_source.remote

import com.example.ihonboarding.feature.login.data_source.remote.dto.ProfileDto
import com.example.ihonboarding.feature.login.data_source.remote.network.ProfileService
import retrofit2.Response
import javax.inject.Inject

class ProfileRemoteDataSourceImpl @Inject constructor(private val profileService: ProfileService) :
    ProfileRemoteDataSource {
    override suspend fun getProfile(): Response<ProfileDto> {
        return profileService.getProfile("Bearer")
    }
}