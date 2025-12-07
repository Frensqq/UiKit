package com.example.uikit.buttons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.R
import com.example.uikit.UI.Placeholders
import com.example.uikit.UI.Typography
import com.example.uikit.components.SpacerH

@Composable
fun LogIn(VkOnClick: () -> Unit,YandexOnClick: () -> Unit ){

    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            "Или войдите с помощью", color = Placeholders
            , style = Typography().Text_Regular
        )

        SpacerH(16)

        LogInButton(R.drawable.vk, "VK", VkOnClick)

        SpacerH(16)

        LogInButton(R.drawable.yandex, "Yandex", YandexOnClick)
    }
}

@Preview
@Composable
fun PreviewLogIn(){
    LogIn({}, {})
}