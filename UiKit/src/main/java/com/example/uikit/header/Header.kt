package com.example.uikit.header

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Black
import com.example.uikit.UI.Placeholders
import com.example.uikit.UI.Typography
import com.example.uikit.bubble.buttonBack
import com.example.uikit.components.SpacerH
import com.example.uikit.components.SpacerW

@Composable
fun headerCart(onClickTrash: () -> Unit, onClickbuttonBack:() -> Unit){

    Column(modifier = Modifier.fillMaxWidth().height(84.dp).background(Color.White)) {

        Row(modifier = Modifier.padding(end = 11.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom) {

            buttonBack {
                onClickbuttonBack()
            }

            Icon(
                painter = painterResource(R.drawable.icon_delete),
                contentDescription = null, tint =Placeholders,
                modifier = Modifier.size(20.dp).clickable{onClickTrash()}
            )
        }

        SpacerH(24)

        Text("Корзина", style = Typography().Title1_ExtraBold, color = Black)
    }
}

@Composable
fun smallHeaderCart(onClickTrash: () -> Unit, onClickbuttonBack:() -> Unit){



        Row(modifier = Modifier.fillMaxWidth().height(48.dp).padding(start = 20.dp, end= 26.dp), horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top) {

            buttonBack {

                onClickbuttonBack()
            }

            Text("Корзина", style = Typography().Title1_ExtraBold, color = Black,
                modifier = Modifier.clickable{onClickTrash}.padding(top = 2.dp))

            Icon(
                painter = painterResource(R.drawable.icon_delete),
                contentDescription = null, tint =Placeholders,
                modifier = Modifier.padding(top = 6.dp).size(20.dp)
            )

        }


}

@Preview
@Composable
fun PreviewheaderCart(){
    Column {
        headerCart({}, {})
        smallHeaderCart({}, {})
    }
}