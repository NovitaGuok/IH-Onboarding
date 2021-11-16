package com.example.ihonboarding.util

class NetworkException(msg: String?, errCode: ErrorCode) : Throwable("This function is not used") {
    val errCode = errCode
}