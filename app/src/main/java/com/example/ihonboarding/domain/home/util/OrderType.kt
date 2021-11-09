package com.example.ihonboarding.domain.home.util

import androidx.room.FtsOptions

sealed class OrderType {
    object Ascending : OrderType()
    object Descending : OrderType()
}
