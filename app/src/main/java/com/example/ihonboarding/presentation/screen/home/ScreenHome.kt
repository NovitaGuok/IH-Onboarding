package com.example.ihonboarding.presentation.screen.home

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ihonboarding.R
import com.example.ihonboarding.domain.home.model.News
import com.example.ihonboarding.presentation.components.headers.Profile
import com.example.ihonboarding.presentation.components.lists.CardTopic
import com.example.ihonboarding.presentation.theme.DarkJungleGreen
import com.example.ihonboarding.presentation.theme.IHOnboardingTheme
import com.example.ihonboarding.presentation.viewmodel.home.NewsListViewModel
import com.example.ihonboarding.util.Resource

@Composable
fun HomePage(
    navController: NavController,
    newsViewModel: NewsListViewModel = hiltViewModel(),
) {
    val state = newsViewModel.newsState.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Column() {
                    Profile(
                        stringResource(R.string.my_name),
                        stringResource(R.string.my_motto),
                        stringResource(R.string.my_url)
                    )
                    Spacer(
                        modifier = Modifier
                            .height(28.dp)
                            .padding(20.dp, 0.dp)
                    )
                    Column(modifier = Modifier.padding(20.dp, 0.dp)) {
                        Text(
                            text = stringResource(R.string.title_home),
                            style = TextStyle(fontWeight = FontWeight.W700, fontSize = 20.sp)
                        )
                        Text(
                            text = stringResource(R.string.subtitle_home),
                            style = TextStyle(color = DarkJungleGreen)
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
            when (state) {
                is Resource.Success -> {
                    items(state.data as List<News>) { news ->
                        CardTopic(news = news)
                    }
                }
                is Resource.Error -> {}
                else -> {}
            }
        }
    }
}

@Composable
fun LoadingIndicator() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    IHOnboardingTheme {
        Surface(color = MaterialTheme.colors.secondary) {
        }
    }
}