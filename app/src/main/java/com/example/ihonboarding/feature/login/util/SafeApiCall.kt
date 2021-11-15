package com.example.ihonboarding.feature.login.util

import com.example.ihonboarding.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

interface SafeApiCall {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())
            } catch (e: Throwable) {
                when (e) {
                    is HttpException -> Resource.Failure(
                        null, null, false, e.code(),
                        e.response()?.errorBody()!!
                    )
                    else -> Resource.Failure(null, null, true, null, null)
                }
            }
        }
    }
}