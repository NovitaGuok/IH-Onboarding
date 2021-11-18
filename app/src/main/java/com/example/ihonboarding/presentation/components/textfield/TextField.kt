package com.example.ihonboarding.presentation.components.textfield

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ihonboarding.R
import com.example.ihonboarding.presentation.theme.Monsoon

@Composable
fun CustomTextField(value: String, validator: Boolean) {
//    TextField(
//        value = viewModel.username.value,
//        isError = viewModel.usernameValidator.value,
//        onValueChange = { viewModel.username.value = it.trim() },
//        label = { Text(stringResource(R.string.label_email), color = Monsoon) },
//        colors = TextFieldDefaults.textFieldColors(
//            backgroundColor = Color.Transparent,
//            focusedIndicatorColor = Monsoon,
//            unfocusedIndicatorColor = Monsoon,
//        ),
//        modifier = modifier
//    )
//    Spacer(modifier = Modifier.padding(vertical = 24.dp))
}