package com.example.uikit.keyboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Black
import com.example.uikit.UI.White
import com.example.uikit.components.SpacerH
import com.example.uikit.components.SpacerW

@Composable
fun keyBoard(onPin: (List<Int>) -> Unit = {}){

    var digitNumber by remember { mutableStateOf(0) }
    var pinArray by remember { mutableStateOf(mutableListOf<Int>()) }


    Column(modifier = Modifier.fillMaxSize().padding(start = 43.dp, end = 44.dp)) {

            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(3),
                verticalItemSpacing = 24.dp,
                horizontalArrangement = Arrangement.spacedBy(24.dp),

            ) {
                items(9) { index ->

                    circleButton(index+1, {
                        currentNumber ->

                        if (digitNumber< 4) {
                            pinArray.add(currentNumber)
                            digitNumber += 1
                            onPin(pinArray)

                        }
                        else{
                            pinArray.clear()
                            pinArray.add(currentNumber)
                            digitNumber = 1
                            onPin(pinArray)
                        }
                    })
                }

            }


        SpacerH(24)

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {

            SpacerW(80)

            circleButton(0, {
                    currentNumber ->

                if (digitNumber< 4) {
                    pinArray.add(currentNumber)
                    digitNumber += 1
                    onPin(pinArray)
                }
                else{
                    pinArray.clear()
                    pinArray.add(currentNumber)
                    digitNumber = 1
                    onPin(pinArray)
                }
            })

            Box(modifier = Modifier.size(80.dp),
                contentAlignment = Alignment.Center) {

                Icon(
                    painter = painterResource(R.drawable.del_icon),
                    contentDescription = null,
                    tint = Black,
                    modifier = Modifier.clickable{
                        if (digitNumber>0 ) {
                            pinArray.removeAt(pinArray.size - 1)
                            digitNumber -= 1
                            onPin(pinArray)
                        }
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

        Text(pinArray.toString())

        keyBoard({currentPinArray ->
            pinArray = currentPinArray.toMutableList()
        })
    }
}
