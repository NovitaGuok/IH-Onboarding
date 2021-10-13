package com.example.ihonboarding.ui.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.material.icons.outlined.ThumbDown
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ihonboarding.R
import com.example.ihonboarding.ui.theme.IHOnboardingTheme

class ItemListTopic : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IHOnboardingTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    CardTopic(
                        "John Stones Reborn When City Get Rid of Manchester United",
                        "7 Jan 21"
                    )
                }
            }
        }
    }
}

@Composable
fun CardTopic(title: String, publishTime: String) {
    val bottomTextStyle = TextStyle(color = Color(0xFF979797), fontWeight = FontWeight.W600)
    val iconTint = Color(0xFF979797)
    val iconSize = 16.dp
    val reactionPadding = 1.dp
    val counterSpaceSize = 2.dp
    val reactionSpaceSize = 4.dp

    Card(
        backgroundColor = MaterialTheme.colors.primary,
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp),
        elevation = 8.dp
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.razor),
                    contentDescription = "Profile picture",
                    contentScale = ContentScale.FillWidth,
                )
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp, 8.dp)) {
                Text(
                    text = title,
                    style = TextStyle(color = Color.Black, fontWeight = FontWeight.W700),
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box() {
                        Row(modifier = Modifier.padding(reactionPadding)) {
                            Icon(
                                Icons.Outlined.Visibility,
                                "views",
                                tint = iconTint,
                                modifier = Modifier.size(iconSize)
                            )
                            Spacer(modifier = Modifier.padding(counterSpaceSize))
                            Text(text = "5", style = bottomTextStyle)
                        }
                    }
                    Spacer(modifier = Modifier.padding(reactionSpaceSize))
                    Box() {
                        Row(modifier = Modifier.padding(reactionPadding)) {
                            Icon(
                                Icons.Outlined.Comment,
                                "comments",
                                tint = iconTint,
                                modifier = Modifier.size(iconSize)
                            )
                            Spacer(modifier = Modifier.padding(counterSpaceSize))
                            Text(text = "4", style = bottomTextStyle)
                        }
                    }
                    Spacer(modifier = Modifier.padding(reactionSpaceSize))
                    Box() {
                        Row(modifier = Modifier.padding(reactionPadding)) {
                            Icon(
                                Icons.Outlined.ThumbUp,
                                "likes",
                                tint = iconTint,
                                modifier = Modifier.size(iconSize)
                            )
                            Spacer(modifier = Modifier.padding(counterSpaceSize))
                            Text(text = "2", style = bottomTextStyle)
                        }
                    }
                    Spacer(modifier = Modifier.padding(reactionSpaceSize))
                    Box() {
                        Row(modifier = Modifier.padding(reactionPadding)) {
                            Icon(
                                Icons.Outlined.ThumbDown,
                                "dislikes",
                                tint = iconTint,
                                modifier = Modifier.size(iconSize)
                            )
                            Spacer(modifier = Modifier.padding(counterSpaceSize))
                            Text(text = "2", style = bottomTextStyle)
                        }
                    }
                    Text(
                        text = publishTime,
                        style = bottomTextStyle,
                        textAlign = TextAlign.Right,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    IHOnboardingTheme {
        CardTopic("John Stones Reborn When City Get Rid of Manchester United", "7 Jan 21")
    }
}