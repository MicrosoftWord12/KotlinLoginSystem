package com.microsoft12.hardcodedloginplatform

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Login System with Feet to Metre Conversion",
    ) {
        App()
    }
}