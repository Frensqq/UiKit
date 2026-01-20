package com.example.uikit.modal

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.InputStr
import com.example.uikit.UI.Typography
import com.example.uikit.components.SpacerH
import com.example.uikit.components.circleClose

@Composable
fun modal( text: String,onClose: () -> Unit, content: @Composable () -> Unit){

    modalBackground({

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
        ) {
            Text(
                text,
                modifier = Modifier.fillMaxWidth(0.75f),
                style = Typography().Title2_SemiBold,
            )
            Box(modifier = Modifier.fillMaxWidth(),contentAlignment = Alignment.TopEnd) {
                circleClose(InputStr, onClick = onClose)
            }
        }
    },{
        content()
    })
}

@Preview
@Composable
fun Previewmodal(){

    modal("Рубашка Воскресенье для машинного вязания", {}, )
    {
        Column {

            Text("Мы можем передать сюда любую Composable функцию")

            SpacerH(8)

            Text("Мой выбор для этих шапок – кардные составы, которые раскрываются деликатным пушком. Кашемиры, мериносы, смесовки с ними отлично подойдут на шапку.\n" +
                    "Кардные составы берите в большое количество сложений, вязать будем резинку 1х1, плотненько.\n"
                    )
        }
    }
}