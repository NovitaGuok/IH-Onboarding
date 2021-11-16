package com.example.ihonboarding.feature.login.data_source.remote

import com.example.ihonboarding.domain.login.model.Token
import com.example.ihonboarding.feature.login.data_source.remote.network.AuthService
import com.example.ihonboarding.feature.login.data_source.remote.dto.AuthReqDto
import com.example.ihonboarding.feature.login.data_source.remote.dto.TokenDto
import com.example.ihonboarding.feature.login.data_source.remote.util.TokenDtoMapper
import com.example.ihonboarding.util.ErrorCode
import com.example.ihonboarding.util.NetworkException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(private val authService: AuthService) :
    AuthRemoteDataSource {
    override suspend fun login(username: String, password: String): TokenDto = withContext(Dispatchers.IO) {
        try {
            val res = authService.login(AuthReqDto(username, password))

            if (res.isSuccessful) return@withContext res.body() as TokenDto
            else throw NetworkException(res.message(), ErrorCode.getErrorCode(res.code()))
        } catch (e: Exception) {
            throw NetworkException(e.localizedMessage.toString(), ErrorCode.UNKNOWN_ERROR)
        }
    }

    override suspend fun refreshToken(): TokenDto = withContext(Dispatchers.IO) {
        try {
            val res = authService.refreshToken()

            if (res.isSuccessful) return@withContext res.body() as TokenDto
            else throw NetworkException(res.message(), ErrorCode.UNKNOWN_ERROR)
        } catch (e: Exception) {
            throw NetworkException(e.localizedMessage.toString(), ErrorCode.UNKNOWN_ERROR)
        }
    }

}