package com.example.uikit.Preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White
import com.example.uikit.bubble.buttonBack
import com.example.uikit.bubble.filterIcon
import com.example.uikit.buttons.LogIn
import com.example.uikit.buttons.bigButton
import com.example.uikit.buttons.cartButton
import com.example.uikit.buttons.chips
import com.example.uikit.buttons.smallButton
import com.example.uikit.cards.cardCart
import com.example.uikit.cards.primaryCard
import com.example.uikit.cards.projectCard
import com.example.uikit.components.SpacerH
import com.example.uikit.components.Tabbar
import com.example.uikit.components.authorizationTitle
import com.example.uikit.components.categoryMenu
import com.example.uikit.controls.counter
import com.example.uikit.controls.toggle
import com.example.uikit.header.headerCart
import com.example.uikit.header.headerCatalog
import com.example.uikit.inputs.inputAndTitle
import com.example.uikit.keyboard.ballonsAndKeyboard
import com.example.uikit.keyboard.keyBoard
import com.example.uikit.modal.modal
import com.example.uikit.modal.snackBar
import com.example.uikit.search.searchField
import com.example.uikit.selects.genderSelect
import com.example.uikit.selects.select

@Composable
fun preview(){

    Column(Modifier.fillMaxSize().fillMaxSize()
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        SpacerH(10)
        buttonBack { }
        SpacerH(10)
        filterIcon {  }
        SpacerH(10)
        Text("bigButton", color = White, style = Typography().Title1_ExtraBold)
        SpacerH(10)
        bigButton("Подтвердить", true) { }
        SpacerH(10)
        bigButton("Подтвердить", false) { }
        SpacerH(10)
        Text("chips", color = White, style = Typography().Title1_ExtraBold)
        SpacerH(10)
        chips(160, 50,"Популярные", true ) { }
        SpacerH(10)
        chips(160, 50,"Детям", false ) { }
        SpacerH(10)
        Text("small", color = White, style = Typography().Title1_ExtraBold)
        SpacerH(10)
        smallButton(true,"Добавить") { }
        SpacerH(10)
        smallButton(false,"Убрать") { }
        SpacerH(25)
        cartButton(500,{})
        SpacerH(25)
        LogIn({}, {})
        SpacerH(25)

        val ListCateg: List<String> = listOf("Популярные","Женщинам","Мужчинам","Детям","Аксессуары")
        var currentCategory by remember { mutableStateOf(ListCateg[0]) }
        categoryMenu(ListCateg,
            currentCategory,
            onClickString = { currCateg ->
                currentCategory = currCateg
            },{})

        SpacerH(25)
        var selectedCategory by remember { mutableStateOf("Главная") }
        Tabbar(
            selectedCategory = selectedCategory,
            {},
            {},
            {},
            {}
        )

        SpacerH(25)
        var value by remember { mutableStateOf("") }
        Box(modifier = Modifier.fillMaxSize()) {

            genderSelect(value,
                { currentValue -> value = currentValue })
        }

        SpacerH(25)
        var list = listOf<String>("Web", "Mobile","Desktop")
        var valueCat by remember { mutableStateOf("") }
        Box(modifier = Modifier.fillMaxSize()) {

            select(valueCat, "Категория",
                list,{ currentValue -> valueCat = currentValue })
        }

        SpacerH(25)
        searchField({}) {  }

        SpacerH(25)
        var valueStr1 by remember { mutableStateOf("") }

        inputAndTitle("Имя", valueStr1,
            false,false,
            "Введите имя", {currValue ->
            valueStr1 = currValue})

        SpacerH(25)
        var valueStr2 by remember { mutableStateOf("") }
        inputAndTitle("Пароль", valueStr2,
            true,false,
            "Введите пароль", {currValue ->
            valueStr2 = currValue})

        SpacerH(25)
        var valueStr3 by remember { mutableStateOf("") }
        inputAndTitle("Ошибка", valueStr3,
            false,true,
            "Введите имя", {currValue ->
            valueStr3 = currValue})

        SpacerH(25)
        counter(1,{})

        SpacerH(25)
        var statetoggle by remember { mutableStateOf(false) }
        toggle(statetoggle,
            {statetoggle = !statetoggle })

        SpacerH(25)
        primaryCard("Рубашка Воскресенье для машинного вязания",
            "Мужская одежда",300,true,
            {})

        SpacerH(25)
        projectCard("Мой первый проект", "2",
            {})

        SpacerH(25)
        cardCart("Рубашка воскресенье для машинного вязания",
            300, 10, {}, {})

        SpacerH(25)
        headerCart({},{})

        SpacerH(25)
        headerCatalog({},{},{})

        SpacerH(25)
        modal("Рубашка Воскресенье для машинного вязания") { }

        SpacerH(25)
        snackBar("Произошла ошибка\n" +
                "Ну вот опять",{})

        SpacerH(25)
        authorizationTitle("Добро пожаловать!",
            "Войдите, чтобы пользоваться функциями приложения")

//        SpacerH(25)
//        var pinArray by remember { mutableStateOf(mutableListOf<Int>()) }
//        Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
//            androidx.compose.material3.Text(pinArray.toString())
//            keyBoard({currentPinArray ->
//                pinArray = currentPinArray.toMutableList()
//            })
//        }
//
//        SpacerH(25)
//        ballonsAndKeyboard({})


    }

}

@Preview
@Composable
fun TestPreview(){

    preview()

}