package com.example.uikit.modal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Description
import com.example.uikit.UI.Typography
import com.example.uikit.components.circleClose

@Composable
fun snackBar(text: String, circleClose: () -> Unit){

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {

        Box(modifier = Modifier.fillMaxWidth().heightIn(min = 130.dp).padding(10.dp)
            .clip(RoundedCornerShape(8.dp)).background(Color.White)
        ) {
            Text(text, style = Typography().Title2_ExtraBold,
                modifier = Modifier.padding(top = 24.dp, start = 20.dp))
        }

        circleClose(Accent,circleClose)

    }
}

@Preview
@Composable
fun PreviewsnackBar(){

    snackBar("Произошла ошибка\nНу вот опять", {})

}
