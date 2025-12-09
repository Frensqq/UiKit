package com.example.uikit.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R

import com.example.uikit.UI.Black
import com.example.uikit.UI.InputStr
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White
import com.example.uikit.components.SpacerW

@Composable
fun LogInButton(img: Int, text: String, onClick: () -> Unit){

    Button(onClick = onClick,
        modifier = Modifier.fillMaxWidth().height(60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = White,
            contentColor = Black
        ),
        border = BorderStroke(1.dp, InputStr),
        shape = RoundedCornerShape(12.dp)
        )
    {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically)
        {
            Image(bitmap = ImageBitmap.imageResource(img),
                contentDescription = null,
                modifier = Modifier.size(32.dp),
                )

            SpacerW(16)

            Text("Войти с ${text}",
                style = Typography().Title3_Medium,
                color = Black,
            )
        }
    }
}

@Preview
@Composable
fun PreviewlogInButton(){
    LogInButton(R.drawable.vk,"VK",{})
}


