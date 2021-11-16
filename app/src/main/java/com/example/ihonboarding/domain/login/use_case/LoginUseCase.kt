package com.example.ihonboarding.domain.login.use_case

import com.example.ihonboarding.domain.login.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val authRepository: AuthRepository) {

}