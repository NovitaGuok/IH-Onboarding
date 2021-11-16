package com.example.ihonboarding.domain.login.use_case

import com.example.ihonboarding.domain.login.repository.AuthRepository
import javax.inject.Inject

class RefreshTokenUseCase @Inject constructor(private val authRepository: AuthRepository){
    suspend operator fun invoke() = authRepository.refreshToken()
}