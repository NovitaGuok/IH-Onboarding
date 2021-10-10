package com.example.ihonboarding.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ihonboarding.R
import com.example.ihonboarding.ui.theme.IHOnboardingTheme

class HomeHeader : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IHOnboardingTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Profile("Novita", "It's never too old to learn", "https://www.linkedin.com/in/novitaguok/")
                }
            }
        }
    }
}

@Composable
fun Profile(name: String, motto: String, url: String) {
    Column(modifier = Modifier.fillMaxSize()) {
        Card(
            backgroundColor = MaterialTheme.colors.primaryVariant,
            shape = RoundedCornerShape(0.dp, 0.dp, 12.dp, 0.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 28.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.razor),
                    contentDescription = "Profile picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(56.dp)
                )
                Column(modifier = Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp)) {
                    Text(
                        text = name,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(
                        text = motto,
                        style = TextStyle(
                            color = Color.White
                        )
                    )
                    Text(
                        text = url,
                        style = TextStyle(
                            color = Color.White
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    IHOnboardingTheme {
        Profile("Novita", "It's never too old to learn", "https://www.linkedin.com/in/novitaguok/")
    }
}