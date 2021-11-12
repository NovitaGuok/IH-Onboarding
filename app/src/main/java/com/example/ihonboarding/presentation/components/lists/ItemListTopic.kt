package com.example.ihonboarding.presentation.components.lists

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
import com.example.ihonboarding.domain.home.model.News
import com.example.ihonboarding.presentation.theme.IHOnboardingTheme
import com.example.ihonboarding.presentation.theme.MountainMist
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun CardTopic(news: News) {
    // Styling
    val bottomTextStyle = TextStyle(color = MountainMist, fontWeight = FontWeight.W600)

    // Date formatter
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    val outputFormat = SimpleDateFormat("d MMM yy")
    val date: Date = inputFormat.parse(news.createdAt)
    val createdAt: String = outputFormat.format(date)

    Card(
        backgroundColor = MaterialTheme.colors.primary,
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 0.dp)
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp, 8.dp)
            ) {
                Text(
                    text = "${news.title}",
                    style = TextStyle(color = Color.Black, fontWeight = FontWeight.W700),
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Reaction(stringResource(R.string.desc_views))
                    Reaction(stringResource(R.string.desc_comments))
                    Reaction(stringResource(R.string.desc_likes))
                    Reaction(stringResource(R.string.desc_dislikes))
                    Text(
                        text = createdAt,
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
    }
}