package com.example.uikit.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.CardStr
import com.example.uikit.UI.White

@Composable
fun backgroundCards(){


    Box(
        Modifier
            .height(138.dp)
            .fillMaxWidth()
            .dropShadow(
                shape = RoundedCornerShape(12.dp),
                shadow = Shadow(
                    radius = 12.dp,
                    spread = 1.dp,
                    color = CardStr,
                )
            )

            .background(
                color = Color.White,
                shape = RoundedCornerShape(12.dp)
            )
    )
}

@Preview
@Composable
fun PrewiewBackGORUNDCards(){

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        backgroundCards()
    }
}
