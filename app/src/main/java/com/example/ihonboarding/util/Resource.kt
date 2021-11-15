package com.example.ihonboarding.util

import okhttp3.ResponseBody

sealed class Resource<T>(
    val data: T? = null,
    val msg: String? = null,
    val isNetworkError: Boolean? = null,
    val errorCode: Int? = null,
    val errorBody: ResponseBody? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(data: T? = null, msg: String) : Resource<T>(data, msg)
    class Failure<T>(data: T? = null, msg: String? = null, isNetworkError: Boolean, errorCode: Int?, errorBody: ResponseBody?) :
        Resource<T>(null, null, isNetworkError, errorCode, errorBody)
    class Loading<T>(data: T? = null) : Resource<T>(data)
}