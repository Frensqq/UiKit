package com.example.uikit.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Black
import com.example.uikit.UI.Description
import com.example.uikit.UI.Typography
import com.example.uikit.components.SpacerW
import com.example.uikit.controls.counter

@Composable
fun cardCart(titleText: String, cost:Int, countStart:Int,
         onCountChange: (Int) -> Unit, onClickIcon: () -> Unit ){
    Box() {

    backgroundCards()

    var count by remember { mutableStateOf(countStart) }



        Column(
            modifier = Modifier.fillMaxWidth().height(138.dp),
            verticalArrangement = Arrangement.SpaceBetween
        )
        {

            Row(
                Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    titleText, style = Typography().Headline_Medium,
                    maxLines = 2, color = Black, modifier = Modifier.fillMaxWidth(0.9f)
                )


                Icon(
                    painter = painterResource(R.drawable.close),
                    contentDescription = null, Modifier.size(20.dp).clickable{
                        onClickIcon()
                    },
                    tint = Description,

                )

            }

            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 20.dp, bottom = 20.dp, end = 9.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text("$cost ₽", style = Typography().Title3_Medium, color = Black)

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Text("$count штук", style = Typography().Text_Regular, color = Black)

                    SpacerW(42)

                    counter(
                        count = count,
                        onCountChange = { newCount ->
                            count = newCount
                            onCountChange(newCount)
                        }
                    )
                }

            }

        }
    }

}

@Preview
@Composable
fun PreviewCart(){
    cardCart("Рубашка воскресенье для машинного вязания", 300, 10, {}, {})
}