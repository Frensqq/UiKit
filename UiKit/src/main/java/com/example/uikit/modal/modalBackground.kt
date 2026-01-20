package com.example.uikit.modal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.uikit.components.SpacerH

@Composable
fun modalBackground(contentTitle: @Composable () -> Unit,content: @Composable () -> Unit ){

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            modifier = Modifier
                .heightIn(80.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp,
                    24.dp,
                    0.dp,
                    0.dp))
                .background(Color.White)
        ){
            SpacerH(24)
            contentTitle()
            SpacerH(20)
        }
        Box(modifier =Modifier.fillMaxWidth().background(Color.White).padding(horizontal = 20.dp) ) {
            content()
        }
    }
}