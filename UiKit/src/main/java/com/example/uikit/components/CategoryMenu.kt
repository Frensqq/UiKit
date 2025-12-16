package com.example.uikit.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.buttons.chips

@Composable
fun categoryMenu(categories: List<String>,
                 selectedCategory:String? = categories[0],
                 onClickString:  (String) -> Unit,
                 onClick: () -> Unit

){

    LazyRow(
       horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(categories) { category ->
            chips(
                140,
                86,
                category,
                selectedCategory == category,
                onClick = {
                    onClickString(category)
                    onClick()
                }
            )
        }
    }
}

@Preview
@Composable
fun PreviewcategoryMenu(){

    val ListCateg: List<String> = listOf("Популярные","Женщинам","Мужчинам","Детям","Аксессуары")

    var currentCategory by remember { mutableStateOf(ListCateg[0]) }

    categoryMenu(ListCateg, currentCategory,
        onClickString = { currCateg ->
            currentCategory = currCateg
        },{}
        )
}