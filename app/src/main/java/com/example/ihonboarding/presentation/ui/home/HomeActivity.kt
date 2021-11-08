package com.example.ihonboarding.presentation.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ihonboarding.di.Injector
import com.example.ihonboarding.presentation.viewmodel.home.NewsViewModel
import com.example.ihonboarding.presentation.viewmodel.home.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        val responseLiveData = newsViewModel.getNews()
        responseLiveData.observe(this, {
            Log.e("TAG", it.toString())
        })
    }

}