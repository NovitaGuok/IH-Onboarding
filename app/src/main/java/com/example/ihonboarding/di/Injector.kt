package com.example.ihonboarding.di

import com.example.ihonboarding.di.news.NewsSubcomponent

interface Injector {
    fun createNewsSubcomponent(): NewsSubcomponent
}