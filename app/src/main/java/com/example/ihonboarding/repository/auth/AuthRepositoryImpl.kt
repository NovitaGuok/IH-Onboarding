package com.example.ihonboarding.repository.auth

import com.example.ihonboarding.data.local.dao.AuthTokenDao
import com.example.ihonboarding.data.local.entity.AuthTokenEntity
import com.example.ihonboarding.data.local.AuthPrefsManager
import com.example.ihonboarding.data.local.mapper.AuthTokenEntityMapper
import com.example.ihonboarding.data.network.model.AuthTokenDto
import com.example.ihonboarding.data.network.mapper.AuthTokenDtoMapper
import com.example.ihonboarding.data.network.requests.AuthLoginRequest
import com.example.ihonboarding.data.network.source.AuthTokenRemoteSource
import com.example.ihonboarding.domain.model.AuthToken
import com.example.ihonboarding.domain.model.ResponseType
import com.example.ihonboarding.domain.model.StateResponse
import com.example.ihonboarding.util.Resources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.json.JSONObject
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton
import javax.security.auth.login.LoginException

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val authTokenRemoteSource: AuthTokenRemoteSource,
    private val authTokenDao: AuthTokenDao,
    private val authTokenDtoMapper: AuthTokenDtoMapper,
    private val authTokenEntityMapper: AuthTokenEntityMapper,
    private val authPrefsManager: AuthPrefsManager
) : AuthRepository {
    override suspend fun login(authLoginRequest: AuthLoginRequest): Flow<Resources<AuthToken>> {
        return authTokenRemoteSource.loginAuthToken(authLoginRequest)
            .map { response ->
                if (response.isSuccessful && response.code() == 200) {
                    response.body()?.let { authTokenDto ->
                        val result = saveAuthToken(authTokenDto, authLoginRequest.email)
                        if (result < 0) {
                            Timber.e("Couldn't save an auth token into db.")
                            throw Exception("Couldn't save an auth token into db.")
                        }
                        saveAuthenticatedUserToDataStorePrefs(authLoginRequest.email)
                        authTokenDto.let {
                            val authTokenDto = it
                            Resources.success(
                                authTokenDtoMapper.mapToDomainModel(authTokenDto)
                            )
                        }
                    } ?: returnUnknownError()
                } else {
                    response.errorBody()?.let { responseBody ->
                        val errorMessage =
                            JSONObject(responseBody.charStream().readText()).getString("error")
                        Resources.error(
                            errorMessage,
                            AuthToken(
                                errorResponse = StateResponse(
                                    message = errorMessage,
                                    errorResponseType = ResponseType.Dialog
                                )
                            )
                        )
                    } ?: returnUnknownError()
                }
            }

    }

    override suspend fun checkPrevAuthUser(): Flow<Resources<AuthToken>> {
        return authPrefsManager.preferencesFlow
            .map { email ->
                if (email.isBlank()) {
                    Timber.d("checkPreviousAuthUser: No previously authenticated user found.")
                    returnNoAuthTokenFound()
                }
                email.let {
                    authTokenDao.searchByEmail(email)?.let { authTokenEntity ->
                        authTokenEntity.id?.let {
                            val id = it
                            if (id > -1) {
                                    authTokenDao.searchById(it)?.let { authToken ->
                                    if (authToken.token != null) {
                                        Resources.success(
                                            authTokenEntityMapper.mapToDomainModel(authToken)
                                        )
                                    } else returnNoAuthTokenFound()
                                }
                            } else returnNoAuthTokenFound()
                        }
                    }
                } ?: returnNoAuthTokenFound()

            }

    }

    private suspend fun saveAuthenticatedUserToDataStorePrefs(email: String) {
        authPrefsManager.saveAuthenticatedUserToDataStore(email)
        Timber.d("Email in ds: ${authPrefsManager.readPreviousAuthUserEmail()}")
    }

    private suspend fun saveAuthToken(authTokenDto: AuthTokenDto, email: String): Long =
        authTokenDao.insert(
            authTokenEntity = AuthTokenEntity(
                token = authTokenDto.token,
                email = email
            )
        )

    private fun returnNoAuthTokenFound(): Resources<AuthToken> {
        return Resources.error(
            "No token found", AuthToken(
                errorResponse = StateResponse(
                    "No token found",
                    errorResponseType = ResponseType.None
                )
            )
        )
    }

    private fun returnUnknownError(): Resources<AuthToken> {
        return Resources.error(
            "Unknown error", AuthToken(
                errorResponse = StateResponse(
                    "Unknown error",
                    errorResponseType = ResponseType.Toast
                )
            )
        )
    }
}
