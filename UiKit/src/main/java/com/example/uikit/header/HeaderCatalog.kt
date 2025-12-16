package com.example.uikit.header

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
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
import com.example.uikit.components.SpacerW
import com.example.uikit.search.searchField

@Composable
fun headerCatalog(onSearchHeader:(String)->Unit,onDone:() -> Unit, onClickProfile: () -> Unit){

    var value by remember { mutableStateOf("") }


    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {

        Box(modifier = Modifier.fillMaxWidth(0.8f)) {
            searchField(
                { currentValue ->
                    value = currentValue

                    onSearchHeader(value)
                },
                onDone
            )
        }

        Icon(
            painter = painterResource(R.drawable.user_icon),
            contentDescription = null,
            modifier = Modifier.size(32.dp).clickable{onClickProfile()},
            tint = Black
        )

    }
}

@Preview
@Composable
fun PreviewheaderCatalog(){

    headerCatalog({},{}, {})
}
