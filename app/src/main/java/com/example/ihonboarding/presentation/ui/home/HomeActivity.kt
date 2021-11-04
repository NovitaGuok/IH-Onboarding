package com.example.ihonboarding.presentation.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ihonboarding.di.Injector
import com.example.ihonboarding.presentation.viewmodel.home.NewsViewModel
import com.example.ihonboarding.presentation.viewmodel.home.NewsViewModelFactory
import timber.log.Timber
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: NewsViewModelFactory
    private lateinit var newsViewModel: NewsViewModel

    @SuppressLint("TimberArgCount")
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        (application as Injector).createNewsSubcomponent().inject(this)
        newsViewModel = ViewModelProvider(this, factory).get(NewsViewModel::class.java)
        val responseLiveData = newsViewModel.getNews()
        responseLiveData.observe(this, Observer {
            Timber.i("TAG", it.toString())
        })
    }
}