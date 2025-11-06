package com.microsoft12.hardcodedloginplatform.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Alignment

@Composable
fun StyledInputField(value: String, onValueChange: (String) -> Unit, textFieldTitle: String, textFieldPlaceholder: String? = null, modifier: Modifier? = null) {
    Column(modifier = modifier ?: Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(textFieldTitle, modifier = Modifier.absolutePadding(top = 10.dp, right = 10.dp, bottom = 10.dp))

        if(textFieldPlaceholder != null) {
            OutlinedTextField(value = value, onValueChange = { onValueChange(it) }, placeholder = { Text(textFieldPlaceholder)}, singleLine = true, textStyle = TextStyle(color = MaterialTheme.colorScheme.primary, textAlign = TextAlign.Center), modifier = Modifier.fillMaxWidth(0.6f), shape = MaterialTheme.shapes.small)
        }
    }
}