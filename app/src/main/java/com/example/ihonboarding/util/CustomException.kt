package com.example.ihonboarding.util

class NetworkException(msg: String?, errCode: ErrorCode) : Throwable(msg) {
    val errCode = errCode
}