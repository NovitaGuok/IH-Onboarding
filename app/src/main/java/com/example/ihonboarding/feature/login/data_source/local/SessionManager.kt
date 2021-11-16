package com.example.ihonboarding.feature.login.data_source.local

interface SessionManager {
    fun getToken(): String?
    fun getExp() :String?
    fun saveSession(token: String, expiredAt: String)
    fun deleteSession()
}