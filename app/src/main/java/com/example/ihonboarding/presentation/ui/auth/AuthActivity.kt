package com.example.ihonboarding.presentation.ui.auth

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import com.example.ihonboarding.presentation.ui.BaseActivity
import com.example.ihonboarding.presentation.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : BaseActivity() {
    private lateinit var navController: NavController
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}