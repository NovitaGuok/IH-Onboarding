package com.example.ihonboarding.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ihonboarding.ui.theme.IHOnboardingTheme

class CustomButton : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IHOnboardingTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    CustomButton("Android")
                }
            }
        }
    }
}

@Composable
fun CustomButton(btnText: String) {
    Button(
        onClick = { /* Do something! */ },
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = MaterialTheme.colors.primaryVariant
        ),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier.fillMaxWidth().padding(0.dp, 4.dp)
    ) {
        Text(btnText)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    IHOnboardingTheme {
        CustomButton("Android")
    }
}