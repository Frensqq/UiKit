package com.example.uikit.modal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.example.uikit.UI.Black
import com.example.uikit.UI.InputIcon
import com.example.uikit.UI.InputStr
import com.example.uikit.UI.Typography
import com.example.uikit.components.SpacerW
import com.example.uikit.components.circleClose

@Composable
fun modal(height:Int, text: String,Close: () -> Unit){

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8,
                    8,
                    0,
                    0))
                .fillMaxWidth()
                .height(height.dp)
                .background(Color.White)
        ) {
            Text(
                text,
                style = Typography().Title2_SemiBold,
                modifier = Modifier.padding(top = 24.dp, start = 20.dp, end = 40.dp)
            )
            Box(modifier = Modifier.align(Alignment.TopEnd).padding(end = 20.dp, top = 24.dp)) {
                circleClose(InputStr,Close)
            }
        }
    }
}

@Preview
@Composable
fun Previewmodal(){

    modal(150,"Рубашка Воскресенье для машинного вязания", {})

}