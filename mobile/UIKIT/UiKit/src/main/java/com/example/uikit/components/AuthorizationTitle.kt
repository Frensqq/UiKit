package com.example.uikit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Black
import com.example.uikit.UI.Typography

@Composable
fun authorizationTitle(titleText: String, text: String){

    Column() {

        Row() {
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.emojies),
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
            SpacerW(16)
            Text(titleText, style = Typography().Title1_ExtraBold,
                color = Black)
        }

        SpacerH(23)

        Text(text, style = Typography().Text_Regular, color = Black)
    }
}

@Preview
@Composable
fun PreviewauthorizationTitle(){

    Box(modifier = Modifier.background(Color.White)) {
        authorizationTitle("Добро пожаловать!", "Войдите, чтобы пользоваться функциями приложения")
    }
}