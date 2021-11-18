package com.example.ihonboarding.domain.login.repository

import com.example.ihonboarding.domain.login.model.Profile
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    fun getProfile(): Flow<Profile>
}