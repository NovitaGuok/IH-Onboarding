package com.example.ihonboarding.util

enum class ErrorCode(val errorCode: Int) {
    CODE_200(200),
    CODE_400(400),
    CODE_401(401),
    CODE_422(422),
    UNKNOWN_ERROR(520);

    companion object {
        fun getErrorCode(errorCode: Int): ErrorCode {
            return values().firstOrNull { it.errorCode == errorCode } ?: UNKNOWN_ERROR
        }
    }
}