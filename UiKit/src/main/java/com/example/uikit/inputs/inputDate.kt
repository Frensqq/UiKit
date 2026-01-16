package com.example.uikit.inputs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SearchBarDefaults.inputFieldColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
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
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateInput(
    value: String,
    placeholder: String,
    onDateSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var showDialog by remember { mutableStateOf(false) }
    val formatter = remember { SimpleDateFormat("yyyy-MM-dd", Locale.US) }

    OutlinedTextField(
        value = value,
        onValueChange = {},
        readOnly = true,
        placeholder = { Text(placeholder) },
        trailingIcon = {
            Icon(
                painterResource(R.drawable.chevrondown),
                null,
                Modifier.clickable { showDialog = true }
            )
        },
        modifier = modifier.fillMaxWidth(),
        colors = inputFieldColors()
    )

    if (showDialog) {
        val datePickerState = rememberDatePickerState()
        DatePickerDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton({
                    datePickerState.selectedDateMillis?.let {
                        onDateSelected(formatter.format(Date(it)))
                    }
                    showDialog = false
                }) { Text("OK") }
            },
            dismissButton = {
                TextButton({ showDialog = false }) { Text("Отмена") }
            }
        ) { DatePicker(datePickerState) }
    }
}

@Preview
@Composable
fun DateInputPreview() {

        var  value by remember { mutableStateOf("") }

        Column(Modifier.padding(16.dp)) {
            DateInput(
                value = value,
                placeholder = "Выберите дату",
                onDateSelected = { date -> value = date }
            )
        }
}