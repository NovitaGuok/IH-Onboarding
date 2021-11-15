package com.example.ihonboarding.feature.login.data_source.remote.api

import okhttp3.ResponseBody
import retrofit2.http.POST

interface BaseService {
    @POST("logout")
    suspend fun logout(): ResponseBody
}