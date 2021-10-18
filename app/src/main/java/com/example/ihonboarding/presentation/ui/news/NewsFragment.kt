package com.example.ihonboarding.presentation.ui.news

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.ihonboarding.presentation.IhOnboardingApplication
import com.example.ihonboarding.presentation.screens.home.HomePage
import com.example.ihonboarding.presentation.theme.IHOnboardingTheme
import com.example.ihonboarding.presentation.viewmodel.NewsListViewModel
import com.example.ihonboarding.util.TAG
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NewsFragment : Fragment() {
    @Inject
    lateinit var app: IhOnboardingApplication

    private val viewModel: NewsListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply {
            setContent {

                val news = viewModel.news.value

                for(item in news) {
                    Log.d(TAG, "onCreateView:${item.title}")
                }

                IHOnboardingTheme {
                    Surface(color = MaterialTheme.colors.background) {
                        HomePage()
                    }
                }
            }
        }
    }
}