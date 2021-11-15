package com.example.ihonboarding.domain.login.use_case

import com.example.ihonboarding.domain.login.model.Token
import com.example.ihonboarding.domain.login.repository.AuthRepository
import javax.inject.Inject
import javax.inject.Named

class LoginUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(username: String, password: String): Token {
        return authRepository.login(username, password)
    }
}