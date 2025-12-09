package com.example.uikit.selects


import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Black
import com.example.uikit.UI.Description
import com.example.uikit.UI.InputBg
import com.example.uikit.UI.Placeholders
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White
import com.example.uikit.components.SpacerH
import com.example.uikit.modal.modalBackground

@Composable
fun selectBottomSheet(value: String,  text: String,selectOptions:List<String>,onOption: (String) -> Unit ){

    var state by remember { mutableStateOf(false) }
    var currentOption by remember { mutableStateOf(value) }

    TextField(
        readOnly = true,
        shape = RoundedCornerShape(10.dp),
        value = currentOption,
        onValueChange = { },
        placeholder = {
            Text(
                text = text,
                style = Typography().Headline_Regular,
                color = Placeholders
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(R.drawable.chevrondown),
                modifier = Modifier.size(20.dp).clickable{state = !state},
                contentDescription = null,
                tint = Description
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
            .fillMaxWidth()
            .height(50.dp).clickable{state = !state},
        textStyle = Typography().Headline_Regular
    )

    if(state){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
            modalBackground(100)

            Column {
                selectOptions.forEach { option ->

                    Text(option, style = Typography().Headline_Regular, color = Black,
                        modifier = Modifier.fillMaxWidth().clickable{
                            currentOption = option
                            onOption(option)
                            state =!state
                        },
                        textAlign = TextAlign.Center
                    )
                    SpacerH(10)
                }

            }
        }
    }

}

@Preview
@Composable
fun PreviewSelectBottomSheet(){

    var list = listOf<String>("Web", "Mobile","Desktop")
    var text by remember { mutableStateOf("") }

    Column {
        Text(text, style = Typography().Title1_ExtraBold, color = White)

        selectBottomSheet("", "Тип", list, { currentText ->
            text = currentText

        })
    }

}