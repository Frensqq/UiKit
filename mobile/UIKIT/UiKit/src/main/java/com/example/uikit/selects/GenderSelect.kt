@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)

package com.example.uikit.selects

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.modifier.ModifierLocalConsumer
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
fun genderSelect(value: String, oncheck:(String)->Unit){

    val genderOptions = listOf("Мужской", "Женский", "Другое")
    var open by remember { mutableStateOf(false) }


    ExposedDropdownMenuBox(
        expanded = open,
        onExpandedChange = {
            open = !open
        }
    ) {

        TextField(
            readOnly = true,
            shape = RoundedCornerShape(10.dp),
            value = value,
            onValueChange = { },
            placeholder = {
                Text("Пол",
                    style = Typography().Headline_Regular,
                    color = Placeholders) },
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.chevrondown),
                    contentDescription = null,
                    tint = Description,
                )
            },
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
                disabledContainerColor = InputBg,
            ),
            modifier = Modifier
                .border(1.dp, InputBg, RoundedCornerShape(10.dp))
                .menuAnchor()
                .fillMaxWidth()
                .height(50.dp),
            textStyle = Typography().Headline_Regular
        )

        ExposedDropdownMenu(
            expanded = open,
            onDismissRequest = { open = false }
        ) {
            genderOptions.forEach { gender ->
                DropdownMenuItem(
                    text = { Text(gender, style = Typography().Headline_Regular, color = Black) },
                    onClick = {
                        oncheck(gender)
                        open = false
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewgenderSelect(){

    var value by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {

        genderSelect(value, { currentValue -> value = currentValue })
    }

}