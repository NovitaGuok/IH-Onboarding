package com.example.ihonboarding.di.news

import com.example.ihonboarding.presentation.ui.home.HomeActivity
import dagger.Subcomponent

@NewsScope
@Subcomponent(modules = [NewsModule::class])
interface NewsSubcomponent {
    fun inject(homeActivity: HomeActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): NewsSubcomponent
    }
}