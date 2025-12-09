package com.example.uikit.buttons

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White
import com.example.uikit.components.SpacerW

@Composable
fun cartButton( cost:Int, onClick: () -> Unit){

    Button(onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.fillMaxWidth()
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = White,
            containerColor = Accent
        )
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Row() {
                Icon(painter = painterResource(R.drawable.cart),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = White)

                SpacerW(16)

                Text("В корзину",
                    style = Typography().Title3_Semibold,
                    color = White)
            }

            Text("${cost} ₽",
                style = Typography().Title3_Semibold,
                color = White)
        }
    }


}

@Preview
@Composable
fun PreviewCart() {
    cartButton(500, {})
}