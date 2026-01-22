package com.example.uikit.keyboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Black
import com.example.uikit.UI.InputBg
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White

@Composable
fun circleButton(number: Int, onClick: (Int) -> Unit, isPressedFromParent: Boolean = false) {
    val interaction = remember { MutableInteractionSource() }
    val isPressed by interaction.collectIsPressedAsState()

    val currentPressedState = isPressedFromParent || isPressed

    Box(
        Modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(if (currentPressedState) Accent else InputBg)
            .clickable(
                interactionSource = interaction,
                indication = null,
                onClick = { onClick(number) }
            ),
        Alignment.Center
    ) {
        Text(text = number.toString(), style =  Typography().Headline_Medium,
            color = if (currentPressedState) White else Black)
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