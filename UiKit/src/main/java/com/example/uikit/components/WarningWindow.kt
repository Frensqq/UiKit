package com.example.uikit.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.UI.Black
import com.example.uikit.UI.Typography
import com.example.uikit.buttons.bigButton

@Composable
fun WarningWindow(open: Boolean,Tilte: String,text: String): Boolean{

    var openDialog = remember { mutableStateOf(open) }
    AlertDialog(
        onDismissRequest = { openDialog.value= false},
        title = { Text(text = Tilte, style = Typography().Title3_Medium, textAlign =  TextAlign.Center, modifier = Modifier.fillMaxWidth()) },
        text = { Text(text, style = Typography().Text_Regular, textAlign =  TextAlign.Center, modifier = Modifier.fillMaxWidth()) },
        modifier = Modifier.fillMaxWidth(),
        confirmButton = {
            bigButton("OK",true,{ openDialog.value = false } )
        },
        textContentColor = Black,
    )

    return openDialog.value
}


@Preview
@Composable
fun PreviewWarningWindow(){

    WarningWindow(true,"Tilte: String","text: Stringп ппппппппппппппппп ппппппппппппппп ппппппппппппппппппп пппппппппп пппппппппп пппппппппп пппппппппп")
}