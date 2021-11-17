package com.example.ihonboarding.presentation.ui.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.rememberNavController
import com.example.ihonboarding.presentation.screen.login.LoginPage
import com.example.ihonboarding.presentation.theme.IHOnboardingTheme
import com.example.ihonboarding.presentation.viewmodel.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity :  ComponentActivity() {

    val loginViewModel: LoginViewModel by viewModels()

    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IHOnboardingTheme {
                Surface(color = MaterialTheme.colors.secondary) {
                    val navController = rememberNavController()
//                    NavHost(navController = navController, startDestination = "${ Route.HomeScreen }")
                    LoginPage(navController = navController)
                }
            }
        }
    }

}