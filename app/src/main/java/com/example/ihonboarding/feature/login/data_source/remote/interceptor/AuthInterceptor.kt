package com.example.ihonboarding.feature.login.data_source.remote.interceptor

import com.example.ihonboarding.domain.login.use_case.RefreshTokenUseCase
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(private val refreshTokenUseCase: RefreshTokenUseCase) :
    Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = runBlocking {
            refreshTokenUseCase.invoke()
        }
        return chain.proceed(
            chain.request().newBuilder().addHeader("Authorization", value = "Bearer " + token.token)
                .build()
        )
    }
}