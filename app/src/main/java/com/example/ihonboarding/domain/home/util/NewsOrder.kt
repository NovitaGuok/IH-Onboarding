package com.example.ihonboarding.domain.home.util

sealed class NewsOrder(val orderType: OrderType) {
    class Title(orderType: OrderType): NewsOrder(orderType)
    class CreatedAt(orderType: OrderType): NewsOrder(orderType)
}
