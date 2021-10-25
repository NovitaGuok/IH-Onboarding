package com.example.ihonboarding.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ihonboarding.presentation.screens.login.LoginPage
import com.example.ihonboarding.presentation.theme.IHOnboardingTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IHOnboardingTheme {
                Surface(color = MaterialTheme.colors.background) {
                }
            }
        }
    }
}

@Composable
fun navigatePage() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "login_page", builder = {
        composable("login_page", content = { LoginPage(navController = navController)})
    })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IHOnboardingTheme {
        navigatePage()
    }
}