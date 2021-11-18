package com.example.ihonboarding.presentation.ui.home

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import com.example.ihonboarding.presentation.screen.home.HomePage
import com.example.ihonboarding.presentation.theme.IHOnboardingTheme
import com.example.ihonboarding.presentation.viewmodel.home.NewsListViewModel
import com.example.ihonboarding.util.Constant.Companion.TAG
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity :  ComponentActivity() {

    val newsListViewModel: NewsListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IHOnboardingTheme {
                Surface(color = MaterialTheme.colors.secondary) {
                    val navController = rememberNavController()
//                    NavHost(navController = navController, startDestination = "${ Route.HomeScreen }")
                    Log.d(TAG, newsListViewModel.newsState.value.toString())
                    HomePage(navController = navController)
                }
            }
        }
    }

}