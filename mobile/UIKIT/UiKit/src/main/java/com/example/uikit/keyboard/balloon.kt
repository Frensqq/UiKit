package com.example.uikit.keyboard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Accent

@Composable
fun ballon(state: Boolean){

    Box(modifier = Modifier.size(16.dp)
        .clip(CircleShape).background(if(state) Accent
        else Color.Transparent)
        .border(1.dp, color = Accent, shape = CircleShape))

}


@Preview
@Composable
fun Previewballon(){

    Column() {

        ballon(false)
        ballon(true)
    }
}