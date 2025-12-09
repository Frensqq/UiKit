package com.example.uikit.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Black
import com.example.uikit.UI.Description
import com.example.uikit.UI.InputBg
import com.example.uikit.UI.Placeholders
import com.example.uikit.UI.Typography

@Composable
fun searchField(onSearch:(String)->Unit){

    var searchText by remember { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }

    TextField(
        value = searchText,
        onValueChange = {
            searchText = it
            onSearch(it)
        },
        modifier = Modifier.fillMaxWidth().height(48.dp)
            .clip(RoundedCornerShape(10.dp))
            .onFocusChanged{focusState -> isFocused = focusState.isFocused},
        colors = TextFieldDefaults.colors(
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledTextColor = Black,
            cursorColor = Accent,
            focusedTextColor = Black,
            focusedContainerColor = InputBg,
            unfocusedTextColor = Black,
            unfocusedContainerColor = InputBg,
            disabledContainerColor = InputBg,
        ),
        trailingIcon = {
            if (isFocused || searchText.isNotEmpty()) {
                Icon(
                    painter = painterResource(R.drawable.close),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                        .clickable { searchText = "" },
                    tint = Description
                )
            }
        },
        leadingIcon = {
            Icon(painter = painterResource(R.drawable.search),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = Description
            )
        },
        placeholder = {
            Text("Искать описание",
                style = Typography().Headline_Regular,
                color = Placeholders)
        },
        textStyle = Typography().Text_Regular
    )


}

@Preview
@Composable
fun PrewiewSearchField(){

    searchField(onSearch = ({}))
}
