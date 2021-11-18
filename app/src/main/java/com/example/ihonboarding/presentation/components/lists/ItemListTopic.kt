package com.example.ihonboarding.presentation.components.lists

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
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
                val painter = rememberImagePainter(
                    data = news.coverImage
                )
                val painterState = painter.state
                Image(
                    painter = painter,
                    contentDescription = "Cover Image",
                    contentScale = ContentScale.FillWidth,
                )
                if (painterState is ImagePainter.State.Loading) {
                    CircularProgressIndicator()
                }
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
                    Reaction(Icons.Outlined.Visibility, stringResource(R.string.desc_views), news.view)
                    Reaction(Icons.Outlined.Comment, stringResource(R.string.desc_comments), news.comment)
                    Reaction(Icons.Outlined.ThumbUp, stringResource(R.string.desc_likes), news.upvote)
                    Reaction(Icons.Outlined.ThumbDown, stringResource(R.string.desc_dislikes), news.downvote)
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