package com.example.ihonboarding.presentation.ui.home

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.ihonboarding.presentation.Route
import com.example.ihonboarding.presentation.screen.home.HomePage
import com.example.ihonboarding.presentation.theme.IHOnboardingTheme
import com.example.ihonboarding.presentation.viewmodel.home.NewsListViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomeActivity :  ComponentActivity() {

    private lateinit var newsListViewModel: NewsListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IHOnboardingTheme {
                Surface(color = MaterialTheme.colors.secondary) {
                    val navController = rememberNavController()
//                    NavHost(navController = navController, startDestination = "${ Route.HomeScreen }")
                    HomePage(navController = navController)
                }
            }
        }


//        newsListViewModel = ViewModelProvider(this).get(NewsListViewModel::class.java)
//        val responseLiveData = newsListViewModel.getNews()
//        responseLiveData.observe(this, { news ->
//            news?.forEach {
//                Timber.d(it.toString())
//            }
//        })
    }

}