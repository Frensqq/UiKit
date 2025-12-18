package com.example.uikit.inputs

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Black
import com.example.uikit.UI.Description
import com.example.uikit.UI.InputBg
import com.example.uikit.UI.InputStr
import com.example.uikit.UI.Placeholders
import com.example.uikit.UI.Typography
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Date(placeholder: String, value:String, onchange:(String)->Unit) {
    var openDialog by remember { mutableStateOf(false) }

    val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.US)

    //"yyyy-MM-dd HH:mm:ss.SSS'Z'"

    TextField(
        readOnly = true,
        shape = RoundedCornerShape(10.dp),
        value = value,
        onValueChange = { },
        placeholder = { Text(placeholder, style = Typography().Text_Regular, color = Placeholders) },
        trailingIcon = {
            Icon(
                painter = painterResource(R.drawable.chevrondown),
                contentDescription = "",
                tint = Description, modifier = Modifier.clickable { openDialog = true  }
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
            .border(1.dp, InputStr, RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .height(50.dp),
        textStyle = Typography().Text_Regular
    )

    if (openDialog) {

        val datePickerState = rememberDatePickerState()
        DatePickerDialog(
            onDismissRequest = { openDialog = false },
            confirmButton = {
                TextButton(onClick = {
                    datePickerState.selectedDateMillis?.let { mills->
                        val dateString = formatter.format(Date(mills))
                        onchange(dateString)
                    }
                    openDialog = false

                }) {
                    Text("Подтвердить")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    openDialog = false
                }) {
                    Text("Отмена")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}