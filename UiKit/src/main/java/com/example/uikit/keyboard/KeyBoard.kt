package com.example.uikit.keyboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Black
import com.example.uikit.UI.Description
import com.example.uikit.UI.White
import com.example.uikit.components.SpacerH
import com.example.uikit.components.SpacerW
@Composable
fun keyBoard(onPin: (List<Int>) -> Unit = {}) {
    var pin by remember { mutableStateOf(emptyList<Int>()) }

    Column(Modifier.fillMaxWidth().padding(horizontal = 43.dp)
        .height(392.dp)) {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.FixedSize( 80.dp),
            verticalItemSpacing = 24.dp,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            items(9) { i ->
                circleButton(i + 1) {
                    pin = if (pin.size < 4) pin + (i + 1) else listOf(i + 1)
                    onPin(pin)
                }
            }
        }
        SpacerH(24)

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                SpacerW(80)

                circleButton(0) {
                    pin = if (pin.size < 4) pin + 0 else listOf(0)
                    onPin(pin)
                }

                Box(Modifier.size(80.dp), Alignment.Center) {
                    Icon(
                        painter = painterResource(R.drawable.del_icon),
                        contentDescription = null,
                        tint = Black ,
                        modifier = Modifier.clickable(pin.isNotEmpty()) {
                            pin = pin.dropLast(1)
                            onPin(pin)
                        }
                    )
                }
            }
    }
}


@Preview
@Composable
fun PreviewkeyBoard(){

    var pinArray by remember { mutableStateOf(mutableListOf<Int>()) }

    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        keyBoard({currentPinArray ->
            pinArray = currentPinArray.toMutableList()
        })

        Text(pinArray.toString(), color = White)
    }
}
