package com.example.uikit.selects

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Typography
import com.example.uikit.UI.inputTextColors
import com.example.uikit.UI.inputsColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Select(
    value: String,
    placeholder: String,
    options: List<String>,
    onValueChange: (String) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = it }) {
        OutlinedTextField(
            value = value,
            onValueChange = {},
            readOnly = true,
            placeholder = { Text(placeholder) },
            trailingIcon = { Icon(painterResource(R.drawable.chevrondown), null) },
            colors = inputTextColors(),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .menuAnchor(),
            shape = RoundedCornerShape(10.dp),
            textStyle = Typography().Headline_Regular
        )

        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
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