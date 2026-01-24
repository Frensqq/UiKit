package com.example.uikit.UI

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Accent = Color(0xFF2074F2)
val AccentInactive = Color(0xFFC5D2FF)
val Black = Color(0xFF2D2C2C)
val White = Color(0xFFF7F7F7)
val Error = Color(0xFFFF4646)
val Success = Color(0xFF00B412)
val InputBg = Color(0xFFF7F7FA)
val InputStr = Color(0xFFE6E6E6)
val InputIcon = Color(0xFFBFC7D1)
val Placeholders = Color(0xFF98989A)
val Description = Color(0xFF8787A1)
val CardStr = Color(0xFF8787A1)

@Composable
fun inputTextColors() = OutlinedTextFieldDefaults.colors(
    focusedTextColor = Black,
    focusedBorderColor = Accent,
    focusedContainerColor = InputBg,
    focusedPlaceholderColor = Placeholders,
    disabledContainerColor = InputBg,
    disabledTextColor = Black,
    errorTextColor = Black,
    errorBorderColor = Error,
    errorContainerColor = Color(0x19fd3535) ,
    errorCursorColor = Error,
    cursorColor = Accent,
    unfocusedTextColor = Black,
    unfocusedBorderColor = InputStr,
    unfocusedContainerColor = InputBg,
    unfocusedPlaceholderColor = Placeholders ,
)

@Composable
fun buttonColors() = ButtonColors(
    contentColor = White,
    containerColor = Accent,
    disabledContentColor = White,
    disabledContainerColor = AccentInactive
)



