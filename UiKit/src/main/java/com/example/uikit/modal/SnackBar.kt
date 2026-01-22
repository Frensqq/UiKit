package com.example.uikit.modal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Typography
import com.example.uikit.components.circleClose

@Composable
fun snackBar( circleClose: () -> Unit, content: @Composable () -> Unit ){
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
        Column(modifier = Modifier.fillMaxWidth().heightIn(min = 130.dp).padding(10.dp)
            .clip(RoundedCornerShape(8.dp)).background(Color.White)
        ) {
            content
        }
        circleClose(Accent,{circleClose()})
    }
}

@Preview
@Composable
fun PreviewsnackBar(){
    var count by remember { mutableStateOf(true) }
    Column {
        snackBar({count = false}, {
            Text("Произошла ошибка\nНу вот опять", style = Typography().Title2_ExtraBold,
                modifier = Modifier.padding(top = 24.dp, start = 20.dp))
        })
            Text("$count - колличество")
    }
}
