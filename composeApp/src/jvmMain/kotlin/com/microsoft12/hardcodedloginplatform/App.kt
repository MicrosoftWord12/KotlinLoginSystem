package com.microsoft12.hardcodedloginplatform

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
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
import kotlin.math.roundToInt

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

    val hasLoggedIn = remember { mutableStateOf(false) }

    val hardcodedUsername = "test"
    val hardcodedPass = "password"

    val feetToMetresTitle = remember { mutableStateOf("Enter your feet-to-metres") }

    val feetToMetres = remember { mutableStateOf("") }
    val feetToMetresConversion = remember { mutableStateOf(0.0)}

    DarkTheme {
        Surface(Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    StyledInputField(value = username.value, onValueChange = {
                        username.value = it
                        loginButtonTitle.value = "Login"

                     }, textFieldTitle = usernameFieldText, textFieldPlaceholder = usernameFieldPlaceholder)

                    StyledInputField(value = password.value, onValueChange = {
                        password.value = it
                        loginButtonTitle.value = "Login"

                     }, textFieldTitle = passwordFieldText, textFieldPlaceholder = passwordFieldPlaceholder)


                    if(hasLoggedIn.value) {
                        Button(onClick = {
                            hasLoggedIn.value = false
                            loginButtonTitle.value = "Login"
                            password.value = ""
                            username.value = ""

                        }, modifier = Modifier.absolutePadding(top = 20.dp)) {
                            Text("Logout")
                        }
                    }else{
                        Button(onClick = {
                            if(username.value == hardcodedUsername && password.value == hardcodedPass) {
                                loginButtonTitle.value = "Login Successful"
                                hasLoggedIn.value = true
                            }else {
                                loginButtonTitle.value = "Login Failed: Invalid Credentials"
                            }
                        }, modifier = Modifier.absolutePadding(top = 20.dp)) {
                            Text(loginButtonTitle.value)
                        }
                    }


                    AnimatedVisibility(visible = hasLoggedIn.value) {


                        Column {
                            Text(text = "Hello ${username.value}")

                            StyledInputField(feetToMetres.value, onValueChange = {

                                feetToMetres.value = (it.toDoubleOrNull() ?: (0.0)).toString()
                                feetToMetresConversion.value = (feetToMetres.value.toDouble() * 0.305)

                            }, textFieldTitle = feetToMetresTitle.value, textFieldPlaceholder = "Feet to Metres")
                            Text(feetToMetresConversion.value.roundToInt().toString() + " Metres")
                        }
                    }
                }
            }
        }
    }
}