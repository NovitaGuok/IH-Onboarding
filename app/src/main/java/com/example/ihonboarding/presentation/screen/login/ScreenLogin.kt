package com.example.ihonboarding.presentation.screen.login

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ihonboarding.R
import com.example.ihonboarding.presentation.components.buttons.CustomButton
import com.example.ihonboarding.presentation.theme.IHOnboardingTheme
import com.example.ihonboarding.presentation.theme.Monsoon
import com.example.ihonboarding.presentation.ui.login.LoginActivity
import com.example.ihonboarding.presentation.viewmodel.login.LoginViewModel
import com.example.ihonboarding.util.Resource

@ExperimentalComposeUiApi
@Composable
fun LoginPage(navController: NavController, viewModel: LoginViewModel = hiltViewModel()) {
    val passwordVisibility = remember { mutableStateOf(false) }
    val state = viewModel.state.value

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxHeight(),
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
            value = viewModel.username.value,
            isError = viewModel.usernameValidator.value,
            onValueChange = { viewModel.username.value = it.trim() },
            label = { Text(stringResource(R.string.label_email), color = Monsoon) },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Monsoon,
                unfocusedIndicatorColor = Monsoon,
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
            value = viewModel.password.value,
            isError = viewModel.passwordValidator.value,
            onValueChange = { viewModel.password.value = it.trim() },
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
//        CustomButton(btnText = stringResource(R.string.btn_login))
        Button(
            onClick = {
                if (viewModel.checkValidity()) viewModel.login()
            },
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = MaterialTheme.colors.primaryVariant
            ),
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 4.dp)
        ) {
            Text(stringResource(R.string.btn_login))
        }
        when (viewModel.state.value) {
            is Resource.Success -> {
                Toast.makeText(
                    LocalContext.current,
                    "Showing toast....",
                    Toast.LENGTH_SHORT
                ).show()
                viewModel.resetState()
            }
            is Resource.Error -> {
                Toast.makeText(
                    LocalContext.current,
                    viewModel.username.value + viewModel.password.value,
                    Toast.LENGTH_SHORT
                ).show()
                viewModel.resetState()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    IHOnboardingTheme {
//        LoginPage(navController = rememberNavController(), viewModel = LoginViewModel())
    }
}