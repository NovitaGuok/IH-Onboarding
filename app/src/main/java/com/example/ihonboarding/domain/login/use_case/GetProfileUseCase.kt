package com.example.ihonboarding.domain.login.use_case

import com.example.ihonboarding.domain.login.model.Profile
import com.example.ihonboarding.domain.login.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProfileUseCase @Inject constructor(private val profileRepository: ProfileRepository) {
    operator fun invoke(): Flow<Profile> {

        return profileRepository.getProfile()
    }
}