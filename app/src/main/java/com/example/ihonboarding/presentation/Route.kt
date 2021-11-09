package com.example.ihonboarding.presentation

sealed class Route (val route: String) {
    object HomeScreen: Route("home_screen")
    object LoginScreen: Route("login_screen")
}