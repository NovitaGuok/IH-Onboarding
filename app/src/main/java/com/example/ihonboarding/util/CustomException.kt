package com.example.ihonboarding.util

class DysfunctionException() : Throwable("This function is not used") {}
class NetworkException(msg: String?, errCode: ErrorCode) : Throwable("This function is not used") {
    val errCode = errCode
}