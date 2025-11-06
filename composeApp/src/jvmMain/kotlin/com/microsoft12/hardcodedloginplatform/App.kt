package com.microsoft12.hardcodedloginplatform

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.microsoft12.hardcodedloginplatform.ui.components.StyledInputField
import com.microsoft12.hardcodedloginplatform.ui.styles.DarkTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val username = remember { mutableStateOf("") }
    val usernameFieldText = "Please Enter your Email in the required field:"
    val usernameFieldPlaceholder = "Email Here:"

    val password = remember { mutableStateOf("") }
    val passwordFieldText = "Please Enter your Password in the required field:"
    val passwordFieldPlaceholder = "Password Here:"

    val loginButtonTitle = remember { mutableStateOf("Login") }

    val hardcodedUsername = "username"
    val hardcodedPass = "password"

    DarkTheme {
        Surface(Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    StyledInputField(value = username.value, onValueChange = { username.value = it }, textFieldTitle = usernameFieldText, textFieldPlaceholder = usernameFieldPlaceholder)

                    StyledInputField(value = password.value, onValueChange = { password.value = it }, textFieldTitle = passwordFieldText, textFieldPlaceholder = passwordFieldPlaceholder)

                    Button(onClick = {
                        if(username.value == hardcodedUsername && password.value == hardcodedPass) {
                            loginButtonTitle.value = "Login Successful"
                        }else {
                            loginButtonTitle.value = "Login Failed: Invalid Credentials"
                        }
                    }, modifier = Modifier.absolutePadding(top = 20.dp)) {
                        Text(loginButtonTitle.value)
                    }
                }
            }
        }
    }
}