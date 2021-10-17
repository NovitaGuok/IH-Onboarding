package com.example.ihonboarding.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ihonboarding.R
import com.example.ihonboarding.presentation.components.CardTopic
import com.example.ihonboarding.presentation.components.Profile
import com.example.ihonboarding.presentation.theme.DarkJungleGreen
import com.example.ihonboarding.presentation.theme.IHOnboardingTheme

@Composable
fun HomePage() {
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
                        text = "Hot Topics",
                        style = TextStyle(fontWeight = FontWeight.W700, fontSize = 20.sp)
                    )
                    Text(
                        text = "See What’s Happening in the World",
                        style = TextStyle(color = DarkJungleGreen)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        item {
            Column(modifier = Modifier.padding(20.dp, 0.dp)) {
                CardTopic(
                    title = stringResource(R.string.card_title),
                    publishTime = stringResource(R.string.card_time)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    IHOnboardingTheme {
        Surface(color = MaterialTheme.colors.secondary) {
            HomePage()
        }
    }
}