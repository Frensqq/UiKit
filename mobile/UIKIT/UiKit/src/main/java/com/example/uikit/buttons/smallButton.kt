package com.example.uikit.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White

@Composable
fun smallButton(State:Boolean, text: String, onClick: () -> Unit) {



    Button(onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.height(40.dp)
            .width(96.dp),
        colors = if (State) ButtonDefaults.buttonColors(
            contentColor = White,
            containerColor = Accent,
            disabledContainerColor = Accent,
            disabledContentColor = White
            )
            else ButtonDefaults.buttonColors(
            contentColor = Accent,
            containerColor = White,
            disabledContainerColor = White,
            disabledContentColor = Accent
            ),
        contentPadding = PaddingValues(10.dp),
        border = BorderStroke(1.dp, Accent)
        ){
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = text, style = Typography().Caption_Semibold,
            color = if (State) White else Accent, maxLines = 1 )
        }
    }

}

@Preview
@Composable
fun PreviewSmallButton() {
    smallButton(true,"smallButton", {})
}

