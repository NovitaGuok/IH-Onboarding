package com.example.ihonboarding.feature.login.repository

import com.example.ihonboarding.domain.login.model.Token
import com.example.ihonboarding.domain.login.repository.AuthRepository
import com.example.ihonboarding.feature.login.data_source.local.SessionManager
import com.example.ihonboarding.feature.login.data_source.remote.AuthRemoteDataSource
import com.example.ihonboarding.feature.login.data_source.remote.util.TokenDtoMapper
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val sessionManager: SessionManager,
) : AuthRepository {
    override suspend fun login(username: String, password: String): Token {
        val res = authRemoteDataSource.login(username, password)
        val tokenDtoMapper = TokenDtoMapper()
        sessionManager.saveSession(res.token, res.expiresAt)
        return res.let { tokenDtoMapper.mapToDomainModel(it) }
    }

    override suspend fun refreshToken(): Token {
        val exp = sessionManager.getExp()
        val tokenDtoMapper = TokenDtoMapper()
        return try {
            if (TimeHelper.isInHourTime(exp)) {
                val res = authRemoteDataSource.refreshToken()
                sessionManager.saveSession(res.token, res.expiresAt)
                res.let { tokenDtoMapper.mapToDomainModel(it) }
            } else {
                Token(exp ?: "", sessionManager.getToken() ?: "")
            }
        } catch (e: Throwable) {
            Token(exp ?: "", sessionManager.getToken() ?: "")
        }
    }

    override fun isLoggedIn(): Boolean {
        val exp = sessionManager.getExp()
        if (sessionManager.getToken().isNullOrBlank() && sessionManager.getExp()
                .isNullOrBlank() && TimeHelper.isDatePassed(exp)
        ) return false

        return true
    }

    object TimeHelper {
        private const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"

        fun isDatePassed(dateTime: String?): Boolean {
            val parsedDate = SimpleDateFormat(DATE_FORMAT).parse(dateTime)
            return parsedDate.after(Calendar.getInstance().time)
        }

        fun isInHourTime(dateTime: String?): Boolean {
            val parsedDate = SimpleDateFormat(DATE_FORMAT).parse(dateTime)
            val currTime = Calendar.getInstance()
            return parsedDate.before(currTime.time) && parsedDate.after(currTime.apply {
                add(Calendar.HOUR_OF_DAY, -1)
            }.time)
        }
    }
}