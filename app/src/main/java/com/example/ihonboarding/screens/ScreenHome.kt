package com.example.ihonboarding.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ihonboarding.components.CardTopic
import com.example.ihonboarding.components.Profile
import com.example.ihonboarding.ui.theme.IHOnboardingTheme

class ScreenHome : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IHOnboardingTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.secondary) {
                    HomePage()
                }
            }
        }
    }
}

@Composable
fun HomePage() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Column() {
                Profile(
                    "Novita",
                    "It's never too old to learn",
                    "https://www.linkedin.com/in/novitaguok/"
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
                        style = TextStyle(color = Color(0xFF222222))
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        item {
            Column(modifier = Modifier.padding(20.dp, 0.dp)) {
                CardTopic(
                    title = "John Stones Reborn When City Get Rid of Manchester United",
                    publishTime = "7 Jan 21"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    IHOnboardingTheme {
        Surface(color = MaterialTheme.colors.secondary) {
            HomePage()
        }
    }
}