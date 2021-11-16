package com.example.ihonboarding.domain.login.use_case

import com.example.ihonboarding.domain.login.repository.AuthRepository
import com.example.ihonboarding.feature.login.data_source.remote.dto.AuthReqDto
import javax.inject.Inject
import javax.inject.Named

class LoginUseCase @Inject constructor(private val authRepository: AuthRepository) {
    suspend fun invoke(username: String, password: String) =
        authRepository.login(username, password)
}