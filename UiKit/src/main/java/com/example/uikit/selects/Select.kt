@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)

package com.example.uikit.selects

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Black
import com.example.uikit.UI.Description
import com.example.uikit.UI.InputBg
import com.example.uikit.UI.Placeholders
import com.example.uikit.UI.Typography

@Composable
fun Select(
    value: String,
    placeholder: String,
    options: List<String>,
    onValueChange: (String) -> Unit,
) {
    var expanded by remember { mutableStateOf(true) }

    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = it }) {
        TextField(
            value = value,
            shape = RoundedCornerShape(10.dp),
            onValueChange = {},
            readOnly = true,
            placeholder = { Text(placeholder, style = Typography().Headline_Regular,
                color = Placeholders) },
            trailingIcon = { Icon(painterResource(R.drawable.chevrondown), null,
                tint = Description) },
            colors = TextFieldDefaults.colors(
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledTextColor = Black,
                cursorColor = Accent,
                focusedTextColor = Black,
                focusedContainerColor = InputBg,
                unfocusedTextColor = Black,
                unfocusedContainerColor = InputBg,
                disabledContainerColor = InputBg),
            modifier = Modifier
                .border(1.dp, InputBg, RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .height(50.dp)
                .menuAnchor(),
            textStyle = Typography().Headline_Regular
        )

        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option, style = Typography().Headline_Regular, color = Black) },
                    onClick = { onValueChange(option); expanded = false }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewSelect(){

    var list = listOf<String>("Web", "Mobile","Desktop")

    var value by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {

        Select(value = value, placeholder = "Пол", options = listOf("Мужской", "Женский", "Другое"),
            {Curr ->
            value = Curr}
        )
    }

}