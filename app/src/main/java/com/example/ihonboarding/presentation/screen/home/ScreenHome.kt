package com.example.ihonboarding.presentation.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ihonboarding.R
import com.example.ihonboarding.presentation.components.headers.Profile
import com.example.ihonboarding.presentation.components.lists.CardTopic
import com.example.ihonboarding.presentation.theme.DarkJungleGreen
import com.example.ihonboarding.presentation.theme.IHOnboardingTheme
import com.example.ihonboarding.presentation.viewmodel.home.NewsListViewModel

@Composable
fun HomePage(
    navController: NavController,
    viewModel: NewsListViewModel = hiltViewModel(),
) {
    val state = viewModel.newsState.value
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
            items(state.newsList) { news ->
                CardTopic(news = news)
            }
        }
//        if (state.error.isNotBlank()) {
//            Text(
//                text = state.error,
//                color = MaterialTheme.colors.error,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 20.dp)
//            )
//        }
//        if (state.isLoading) {
//            CircularProgressIndicator()
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    IHOnboardingTheme {
        Surface(color = MaterialTheme.colors.secondary) {
//            HomePage()
        }
    }
}