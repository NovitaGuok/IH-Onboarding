package com.example.ihonboarding.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ihonboarding.R
import com.example.ihonboarding.ui.components.CustomButton
import com.example.ihonboarding.ui.theme.IHOnboardingTheme
import com.example.ihonboarding.ui.theme.Monsoon

@Composable
fun LoginPage() {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val modifier = Modifier.fillMaxWidth()

        /** Title */
        Text(
            text = stringResource(R.string.title_login),
            modifier = Modifier.padding(0.dp, 64.dp, 0.dp, 96.dp),
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.times_new_roman)),
                fontWeight = FontWeight.W400,
                fontSize = 28.sp
            )
        )

        /** Email field */
        TextField(
            value = email.value,
            onValueChange = { email.value = it.trim() },
            label = { Text(stringResource(R.string.label_email), color = Color(0xFF888888)) },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color(0xFF888888),
                unfocusedIndicatorColor = Color(0xFF888888),
            ),
            modifier = modifier
        )
        Spacer(modifier = Modifier.padding(vertical = 24.dp))

        /** Password field */
        val image = if (passwordVisibility.value)
            painterResource(id = R.drawable.design_ic_visibility)
        else
            painterResource(id = R.drawable.design_ic_visibility_off)
        TextField(
            value = password.value,
            onValueChange = { password.value = it.trim() },
            label = { Text(stringResource(R.string.label_password), color = Monsoon) },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Monsoon,
                unfocusedIndicatorColor = Monsoon,
            ),
            modifier = modifier,
            visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility.value = !passwordVisibility.value
                }) {
                    Icon(painter = image, "eye")
                }
            }
        )
        Spacer(modifier = Modifier.padding(vertical = 24.dp))

        /** Button */
        CustomButton(btnText = stringResource(R.string.btn_login))
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    IHOnboardingTheme {
        LoginPage()
    }
}