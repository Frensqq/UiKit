package com.example.uikit.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.CardStr

@Composable
fun backgroundCards(){

    Box(modifier = Modifier.fillMaxWidth()
        .height(138.dp)
        .clip(RoundedCornerShape(12.dp)).background(Color(0xFFFFFFFF))
        .border(1.dp, CardStr, shape = RoundedCornerShape(12.dp))
    )

}

@Preview
@Composable
fun PrewiewBackGORUNDCards(){
    backgroundCards()
}
