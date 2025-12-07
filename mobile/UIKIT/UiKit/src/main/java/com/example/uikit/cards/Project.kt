package com.example.uikit.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Black
import com.example.uikit.UI.Placeholders
import com.example.uikit.UI.Typography
import com.example.uikit.buttons.smallButton

@Composable
fun projectCard(TextTitle: String, date: String, onClick: () ->Unit){
    Box() {
        backgroundCards()

        Column(
            modifier = Modifier.height(138.dp).padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Text(TextTitle, style = Typography().Headline_Medium, color = Black)

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {

                Text(
                    "Прошло $date дня", modifier = Modifier.padding(bottom = 4.dp),
                    style = Typography().Caption_Semibold, color = Placeholders
                )

                smallButton(true, "Открыть", onClick)

            }


        }
    }
}

@Preview
@Composable
fun PreviewProject(){
    projectCard("Мой первый проект", "2",{})
}