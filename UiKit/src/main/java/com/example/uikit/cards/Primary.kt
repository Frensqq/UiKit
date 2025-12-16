package com.example.uikit.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Black
import com.example.uikit.UI.Placeholders
import com.example.uikit.UI.Typography
import com.example.uikit.buttons.smallButton
import com.example.uikit.components.SpacerH

@Composable
fun primaryCard(TitleName: String, typeText: String,cost:Int, state: Boolean, onClick: () -> Unit){

    Box() {
        backgroundCards()

        var text = if (state) "Добавить" else "Убрать"

        Column(modifier = Modifier.height(138.dp).padding(16.dp)) {
            Text(TitleName, style = Typography().Headline_Medium, color = Black,)

            SpacerH(16)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom
                ) {

                    Text(
                        typeText,
                        style = Typography().Caption_Semibold,
                        color = Placeholders,
                        maxLines = 2
                    )
                    SpacerH(4)
                    Text("$cost ₽", style = Typography().Title3_Semibold, color = Black)

                }
                smallButton(State = state, text, {
                    onClick()
                })
            }

        }
    }
}

@Preview
@Composable
fun PreviewprimaryCard(){
    primaryCard("Рубашка Воскресенье для машинного вязания", "Мужская одежда",300,true,{})
}