package com.example.ihonboarding.util

open class Event <out T> (private val content: T){
    var handled = false
    private set

    fun getContent() = if(handled) {
        null
    } else {
        handled = true
        content
    }
}