package com.example.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.UI.Black

@Composable
fun overlay(){
    Box(modifier = Modifier.fillMaxSize().background(Black.copy(alpha = 0.6f)))
}

@Preview
@Composable
fun Previewoverlay(){

    Box(Modifier.fillMaxSize(0.5f).background(Color.White)) {
        overlay()
    }
}
