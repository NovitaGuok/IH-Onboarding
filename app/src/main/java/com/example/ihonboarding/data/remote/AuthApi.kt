package com.example.ihonboarding.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface AuthApi {
    @GET
    suspend fun getUserList(
//        @Query
    )
}