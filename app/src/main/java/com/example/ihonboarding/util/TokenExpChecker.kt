package com.example.ihonboarding.util

import java.text.SimpleDateFormat
import java.util.*

object TokenExpChecker {
    fun isDatePassed(date: String): Boolean {
        return try {
            SimpleDateFormat(DATE_FORMAT).parse(date)
                .after(Calendar.getInstance().time)
        } catch (e: Exception) {
            true
        }
    }

    fun inHour(date: String): Boolean {
        return try {
            val time = SimpleDateFormat(DATE_FORMAT).parse(date)
            val currentTime = Calendar.getInstance()
            time.before(currentTime.time) && time.after(currentTime.apply {
                add(Calendar.HOUR_OF_DAY, -1)
            }.time)
        } catch (e: Exception) {
            false
        }
    }
}