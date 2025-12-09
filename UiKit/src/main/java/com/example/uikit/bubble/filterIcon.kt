package com.example.uikit.bubble

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R.drawable.filter
import com.example.uikit.UI.Description
import com.example.uikit.UI.InputBg

@Composable
fun filterIcon(onClick: () -> Unit){
    Box(modifier = Modifier.size(48.dp)
        .clip(RoundedCornerShape(10.dp)).clickable(onClick = {onClick})
        .background(InputBg), contentAlignment = Alignment.Center) {

        Icon(
            painter = painterResource(filter),
            contentDescription = null, tint = Description,
            modifier = Modifier.size(20.dp)
        )
    }
}

@Preview
@Composable
fun PreviewfilterIcon(){
    filterIcon({})
}