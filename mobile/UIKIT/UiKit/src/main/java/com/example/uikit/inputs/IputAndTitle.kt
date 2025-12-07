package com.example.uikit.inputs

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.UI.Description
import com.example.uikit.UI.Typography
import com.example.uikit.components.SpacerH

@Composable
fun inputAndTitle(titleText: String,value:String, TypePassword: Boolean,isError:Boolean, placeholderText: String, onValue: (String) -> Unit ){

    Column() {
        Text(
            titleText,
            style = Typography().Caption_Regular,
            color = Description
        )
        SpacerH(8)
        textInputField(value, TypePassword, isError = isError, placeholderText, onValue)
    }
}

@Preview
@Composable
fun PreviewinputAndTitle(){

    var value by remember { mutableStateOf("") }

    inputAndTitle("Имя", value,false,false, "Введите имя", {currValue ->
        value = currValue})

}