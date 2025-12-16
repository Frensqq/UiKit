package com.example.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Placeholders
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White

data class Item(
    val iconId: Int,
    val title: String
)

@Composable
fun Tabbar(selectedCategory:String,
           onClick1: () -> Unit,
           onClick2: () -> Unit,
           onClick3: () -> Unit,
           onClick4: () -> Unit){
    val Items = listOf(
        Item(R.drawable.home, "Главная"),
        Item(R.drawable.catalog, "Каталог"),
        Item(R.drawable.project, "Проекты"),
        Item(R.drawable.profile, "Профиль")
    )

    Box(modifier = Modifier.fillMaxWidth().height(88.dp)
        .background(White) .shadow(
            elevation = 1.dp,
            shape = RectangleShape,
            clip = false,
            ambientColor = Color(0xffB8C1CC),
            spotColor = Color(0xffB8C1CC)
        ))
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 7.dp, top = 8.dp, end = 7.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


                Column(modifier = Modifier.width(76.dp).height(49.dp).
                    clickable{onClick1()},
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Icon(painter = painterResource(Items[0].iconId),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp),
                        tint =  if (selectedCategory == Items[0].title) Accent else Placeholders
                    )

                    Text( Items[0].title,
                        style = Typography().Caption2_Regular,
                        color = if (selectedCategory ==  Items[0].title) Accent else Placeholders
                    )
                }

            Column(modifier = Modifier.width(76.dp).height(49.dp).
            clickable{onClick2()},
                horizontalAlignment = Alignment.CenterHorizontally) {

                Icon(painter = painterResource(Items[1].iconId),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    tint =  if (selectedCategory == Items[1].title) Accent else Placeholders
                )

                Text( Items[1].title,
                    style = Typography().Caption2_Regular,
                    color = if (selectedCategory ==  Items[1].title) Accent else Placeholders
                )
            }

            Column(modifier = Modifier.width(76.dp).height(49.dp).
            clickable{onClick3()},
                horizontalAlignment = Alignment.CenterHorizontally) {

                Icon(painter = painterResource(Items[2].iconId),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    tint =  if (selectedCategory == Items[2].title) Accent else Placeholders
                )

                Text( Items[2].title,
                    style = Typography().Caption2_Regular,
                    color = if (selectedCategory ==  Items[2].title) Accent else Placeholders
                )
            }

            Column(modifier = Modifier.width(76.dp).height(49.dp).
            clickable{onClick4()},
                horizontalAlignment = Alignment.CenterHorizontally) {

                Icon(painter = painterResource(Items[3].iconId),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    tint =  if (selectedCategory == Items[3].title) Accent else Placeholders
                )

                Text( Items[3].title,
                    style = Typography().Caption2_Regular,
                    color = if (selectedCategory ==  Items[3].title) Accent else Placeholders
                )
            }
        }
    }
}

@Preview()
@Composable
fun TabbarPreview_Interactive() {
    var selectedCategory by remember { mutableStateOf("Главная") }



//    Box(modifier = Modifier.height(250.dp).background(Color.White), contentAlignment = Alignment.BottomCenter) {
//        Tabbar(
//            selectedCategory = selectedCategory,
//            onClickString = { category ->
//                selectedCategory = category
//            },
//            onClick = {}
//        )
//    }

}