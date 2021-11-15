package com.example.ihonboarding.feature.login.data_source.local

class AuthLocalDataSourceImpl(): AuthLocalDataSource {
    override fun getToken(): String {
        throw Throwable("Later used")
    }
    override fun getExpiresAt(): String {
        throw Throwable("Later used")
    }
    override fun saveSession(token: String, createdAt: String) {
        throw Throwable("Later used")
    }
    override fun deleteSession() {
        throw Throwable("Later used")
    }
}