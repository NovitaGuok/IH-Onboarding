package com.example.ihonboarding.domain.login.use_case

import com.example.ihonboarding.domain.login.repository.AuthRepository
import javax.inject.Inject

class IsLoggedInUseCase @Inject constructor(private val authRepository: AuthRepository){
    operator fun invoke() = authRepository.isLoggedIn()
}