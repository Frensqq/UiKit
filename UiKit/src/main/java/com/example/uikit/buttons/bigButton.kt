package com.example.uikit.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Accent
import com.example.uikit.UI.AccentInactive
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White


@Composable
fun bigButton( text:String, enabled: Boolean, onClick: () -> Unit){

    Button(onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.fillMaxWidth().height(56.dp),
        enabled = enabled,
        colors = ButtonColors(
            contentColor = White,
            containerColor = Accent,
            disabledContentColor = White,
            disabledContainerColor = AccentInactive
        )
    ){
        Text(text = text,
            style = Typography().Title3_Semibold,
            color = White)
    }
}

@Preview
@Composable
fun PreviewBigButton() {
    bigButton("testButton", false, {})
}