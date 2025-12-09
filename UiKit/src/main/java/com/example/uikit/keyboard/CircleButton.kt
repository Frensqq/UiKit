package com.example.uikit.keyboard

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Black
import com.example.uikit.UI.InputBg
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White

@Composable
fun circleButton(number: Int, onClick: (Int) -> Unit)
{
    var isPressed by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(
                color = if (isPressed) Accent else InputBg
            )
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isPressed = true
                        try {
                            tryAwaitRelease()
                            onClick(number)
                        } finally {
                            isPressed = false
                        }
                    }
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = number.toString(),
            style = Typography().Headline_Medium,
            color = if (isPressed) White else Black
        )
    }
}

@Preview
@Composable
fun PreviewKeyButton(){

    var number by remember { mutableStateOf(0) }

    Column() {

        Text(number.toString(), color = White)

        circleButton(1, {currentNum ->
            number = currentNum
        })

        circleButton(2, {currentNum ->
            number = currentNum
        })

        circleButton(3, {currentNum ->
            number = currentNum
        })

        circleButton(4, {currentNum ->
            number = currentNum
        })

    }
}