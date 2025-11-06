package com.microsoft12.hardcodedloginplatform.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
fun TwoTextStyles() {
    Column {
        Text("Hello World!", color = Color.Red, fontStyle= FontStyle.Italic, fontFamily=FontFamily.Serif)
        Text("Welcome to Compose Multiplatform Development", fontWeight= FontWeight.Bold)
    }
}