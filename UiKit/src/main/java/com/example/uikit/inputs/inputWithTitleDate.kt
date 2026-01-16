package com.example.uikit.inputs

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.uikit.UI.Description
import com.example.uikit.UI.Typography
import com.example.uikit.components.SpacerH

@Composable
fun inputAndTitleDate(title: String, placeholder: String, value:String, onchange:(String)->Unit) {

    Column() {
        Text(
            title,
            style = Typography().Caption_Regular,
            color = Description
        )
        SpacerH(8)
        Date(placeholder, value, onchange)
    }
}