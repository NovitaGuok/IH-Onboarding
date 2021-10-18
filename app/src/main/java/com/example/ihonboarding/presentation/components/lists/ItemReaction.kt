package com.example.ihonboarding.presentation.components.lists

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ihonboarding.presentation.theme.MountainMist

@Composable
fun Reaction(desc: String) {
    val bottomTextStyle = TextStyle(color = MountainMist, fontWeight = FontWeight.W600)
    val iconTint = MountainMist
    val iconSize = 16.dp
    val reactionPadding = 1.dp
    val counterSpaceSize = 2.dp
    val reactionSpaceSize = 4.dp

    Box() {
        Row(modifier = androidx.compose.ui.Modifier.padding(reactionPadding)) {
            Icon(
                Icons.Outlined.Visibility,
                desc,
                tint = iconTint,
                modifier = Modifier.size(iconSize)
            )
            Spacer(modifier = androidx.compose.ui.Modifier.padding(counterSpaceSize))
            Text(text = "5", style = bottomTextStyle)
        }
    }
    Spacer(modifier = androidx.compose.ui.Modifier.padding(reactionSpaceSize))
}