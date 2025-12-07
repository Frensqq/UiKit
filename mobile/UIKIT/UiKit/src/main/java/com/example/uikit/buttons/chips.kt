package com.example.uikit.buttons

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Description
import com.example.uikit.UI.InputBg
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White

@Composable
fun chips(maxwidth:Int,minwidth:Int, text: String, state: Boolean, onClick: () -> Unit){

    Button(onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.height(48.dp)
            .widthIn(max = maxwidth.dp, min = minwidth.dp),
        colors = if (state) ButtonDefaults.buttonColors(
            contentColor = White,
            containerColor = Accent,
            disabledContainerColor = Accent,
            disabledContentColor = White
        )
        else ButtonDefaults.buttonColors(
            contentColor = Description,
            containerColor = InputBg,
            disabledContainerColor = InputBg,
            disabledContentColor = Description
        ),
    ){

        Text(text = text, style = Typography().Text_Medium, color = if (state) White else Description)

    }



}

@Preview
@Composable
fun PreviewChips() {
    chips(129,86,"Детям",true, {})
}