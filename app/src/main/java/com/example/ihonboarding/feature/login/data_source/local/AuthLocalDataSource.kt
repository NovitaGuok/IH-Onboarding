package com.example.ihonboarding.feature.login.data_source.local

interface AuthLocalDataSource {
    fun getToken(): String?
    fun getExpiresAt(): String?
    fun saveSession(token: String, createdAt: String)
    fun deleteSession()
}