package com.example.uikit.controls

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Accent
import com.example.uikit.UI.InputStr
import com.example.uikit.UI.White

@Composable
fun toggle(state: Boolean, onStateChange: () -> Unit)
{

    Box(
        Modifier.height(28.dp).width(48.dp)
            .clip(CircleShape).background(if (state) Accent else InputStr)
    ) {
        Box(modifier = Modifier
            .padding(top = 2.dp , start = if (state) 22.dp else 2.dp, ).size(24.dp)
            .clip(CircleShape).background(White).clickable(onClick = onStateChange)
        )
    }
}

@Preview
@Composable
fun PreviewToggle(){

    var state by remember { mutableStateOf(false) }

    toggle(state, {state = !state })
}