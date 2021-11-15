package com.example.ihonboarding.feature.login.repository

import com.example.ihonboarding.domain.login.model.Token
import com.example.ihonboarding.domain.login.repository.AuthRepository
import com.example.ihonboarding.feature.login.data_source.local.AuthLocalDataSource
import com.example.ihonboarding.feature.login.data_source.remote.AuthRemoteDataSource
import com.example.ihonboarding.feature.login.data_source.remote.dto.toModel
import com.example.ihonboarding.util.TokenExpChecker
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
) : AuthRepository {

    override suspend fun login(email: String, password: String): Token {
        val res = authRemoteDataSource.login(email, password)
        authLocalDataSource.saveSession(res.token, res.expires_at)
        return res.toModel()
    }

    override suspend fun refreshToken(): Token {
        val exp = authLocalDataSource.getExpiresAt()
        return try {
            if (TokenExpChecker.inHour(exp!!)) {
                val res = authRemoteDataSource.refreshToken()
                authLocalDataSource.saveSession(res.token, res.expires_at)
                res.toModel()
            } else {
                Token(exp ?: "", "Bearer", authLocalDataSource.getToken() ?: "")
            }
        } catch (e: Throwable) {
            Token(exp ?: "", "Bearer", authLocalDataSource.getToken() ?: "")
        }
    }
}
