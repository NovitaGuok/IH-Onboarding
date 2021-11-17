package com.example.ihonboarding.presentation.components.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ihonboarding.presentation.theme.IHOnboardingTheme

@Composable
fun CustomButton(btnText: String) {
    Button(
        onClick = { /* Do something! */ },
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = MaterialTheme.colors.primaryVariant
        ),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 4.dp)
    ) {
        Text(btnText)
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    IHOnboardingTheme {
        CustomButton("Android")
    }
}