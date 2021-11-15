package com.example.ihonboarding.feature.login.data_source.remote

import com.example.ihonboarding.feature.login.data_source.remote.api.AuthService
import com.example.ihonboarding.feature.login.data_source.remote.dto.AuthReqDto
import com.example.ihonboarding.feature.login.data_source.remote.dto.TokenDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(private val authService: AuthService) :
    AuthRemoteDataSource {
    override suspend fun login(username: String, password: String): TokenDto {
        return withContext(Dispatchers.IO) {
            try {
                val res = authService.login(AuthReqDto(username, password))

                if (res.isSuccessful) return@withContext res.body() as TokenDto
                else throw Throwable(res.message() + res.code())
            } catch (e: Exception) {
                throw Throwable(e.message)
            }
        }
    }

    override suspend fun refreshToken(): TokenDto {
        return withContext(Dispatchers.IO) {
            try {
                val res = authService.refreshToken()
                if (res.isSuccessful) return@withContext res.body() as TokenDto
                else throw Throwable(res.message() + res.code())
            } catch (e: Exception) {
                throw Throwable(e.message)
            }
        }
    }
}