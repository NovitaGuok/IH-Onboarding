package com.example.ihonboarding.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ihonboarding.R
import com.example.ihonboarding.ui.theme.IHOnboardingTheme

@Composable
fun CardTopic(title: String, publishTime: String) {
    val bottomTextStyle = TextStyle(color = Color(0xFF979797), fontWeight = FontWeight.W600)

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
                    contentDescription = stringResource(R.string.desc_profile_pic),
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
                    Reaction(stringResource(R.string.desc_views))
                    Reaction(stringResource(R.string.desc_comments))
                    Reaction(stringResource(R.string.desc_likes))
                    Reaction(stringResource(R.string.desc_dislikes))
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
fun CardTopicPreview() {
    IHOnboardingTheme {
        CardTopic("John Stones Reborn When City Get Rid of Manchester United", "7 Jan 21")
    }
}