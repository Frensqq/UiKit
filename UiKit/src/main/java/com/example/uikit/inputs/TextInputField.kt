package com.example.uikit.inputs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Black
import com.example.uikit.UI.Error
import com.example.uikit.UI.InputBg
import com.example.uikit.UI.InputStr
import com.example.uikit.UI.Placeholders
import com.example.uikit.UI.Typography

@Composable
fun textInputField(value: String, TypePassword: Boolean, isError:Boolean, placeholderText: String, onValChange:(String)->Unit){

    var hidingPass by remember { mutableStateOf(true) }

    OutlinedTextField(
        value = value,
        onValueChange = { onValChange(it) },
        singleLine = true,
        readOnly = false,
        isError = isError,
        placeholder ={
            Text(text =  placeholderText,
            style = Typography().Text_Regular,
            color = Placeholders)
        },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        trailingIcon = {if (TypePassword){
            if (value.isNotEmpty()){
            Icon(
                painter = painterResource(
                    if (hidingPass) R.drawable.clouse_eyes
                    else (R.drawable.open_eyes)),
                contentDescription = null,
                tint = Black,
                modifier = Modifier.clickable {
                    hidingPass=!hidingPass}
            )}}},
        textStyle = Typography().Text_Regular,

        visualTransformation = if (TypePassword and hidingPass) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = if (TypePassword) KeyboardOptions(keyboardType = KeyboardType.Password) else KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Black,
            focusedBorderColor = Accent,
            focusedContainerColor = InputBg,
            focusedPlaceholderColor = Placeholders,
            errorTextColor = Black,
            errorBorderColor = Error,
            errorContainerColor = Color(0x19fd3535) ,
            errorCursorColor = Error,
            cursorColor = Accent,
            unfocusedTextColor = Black,
            unfocusedBorderColor = InputStr,
            unfocusedContainerColor = InputBg,
            unfocusedPlaceholderColor = Placeholders
        )
        )
}

@Preview
@Composable
fun PrewietextInputField(){

    var value by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {

        textInputField(value, true, false, "Введите текст", {CurrValue ->
            value = CurrValue
        })
    }
}