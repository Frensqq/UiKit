package com.example.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Description

@Composable
fun circleClose(colorBack: Color, onClick: () -> Unit){

    Box(modifier = Modifier.size(24.dp)
        .clip(CircleShape).background(colorBack)
        .clickable{onClick()},
        contentAlignment = Alignment.Center)
    {

        Icon(
            painter = painterResource(R.drawable.close),
            tint = Description, contentDescription = null
        )

    }

}

@Preview
@Composable
fun PreviewcircleClose(){
    circleClose(Accent, {})
}