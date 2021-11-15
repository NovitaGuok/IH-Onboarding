package com.example.ihonboarding.domain.login.use_case

import com.example.ihonboarding.domain.login.model.Token
import com.example.ihonboarding.domain.login.repository.AuthRepository
import javax.inject.Inject
import javax.inject.Named

class RefreshTokenUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(): Token {
        return authRepository.refreshToken()
    }
}