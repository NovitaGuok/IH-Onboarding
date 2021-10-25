package com.example.ihonboarding.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import com.example.ihonboarding.session.SessionManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var sessionManager: SessionManager
}