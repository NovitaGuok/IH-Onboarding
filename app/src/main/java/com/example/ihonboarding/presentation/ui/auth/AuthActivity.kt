package com.example.ihonboarding.presentation.ui.auth

import androidx.navigation.NavController
import com.example.ihonboarding.presentation.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : BaseActivity() {
    private lateinit var navController: NavController
    private val authViewModel: AuthView
}