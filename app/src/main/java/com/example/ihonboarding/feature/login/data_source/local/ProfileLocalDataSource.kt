package com.example.ihonboarding.feature.login.data_source.local

import com.example.ihonboarding.feature.login.data_source.local.entity.ProfileEntity
import kotlinx.coroutines.flow.Flow

interface ProfileLocalDataSource {
    fun getLocalProfile(): Flow<ProfileEntity>
    suspend fun insertLocalProfile(profile: ProfileEntity)
}