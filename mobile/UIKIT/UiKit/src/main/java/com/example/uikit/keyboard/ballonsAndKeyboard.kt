package com.example.uikit.keyboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.components.SpacerH

@Composable
fun ballonsAndKeyboard(onPin: (List<Int>) -> Unit = {}){

    var pinArray by remember { mutableStateOf(mutableListOf<Int>()) }

    Column(modifier = Modifier.fillMaxSize()) {

        LazyRow(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center)
        {items(4) {item ->

            Box(modifier = Modifier.padding(horizontal = 6.dp)) {
                ballon(pinArray.size > item)
            }

        } }

        SpacerH(60)

        keyBoard { currentPin ->
            pinArray = currentPin.toMutableList()
            onPin(pinArray)
        }
    }
}

@Preview
@Composable
fun PreviewballonsAndKeyboard(){
    ballonsAndKeyboard({})
}