package com.example.uikit.controls

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.InputIcon
import com.example.uikit.UI.InputStr
import com.example.uikit.UI.Placeholders

@Composable
fun counter(count:Int, onCountChange: (Int) -> Unit){



    Box(modifier = Modifier.height(32.dp).width(64.dp)
        .clip(RoundedCornerShape(8.dp)).background(Color(0xFFf5f5f9))
    ) {
        Row(modifier = Modifier.padding(6.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {

            Icon(
                painter = painterResource(R.drawable.icon_minus),
                contentDescription = null,
                tint = if (count <=1) {InputIcon} else {Placeholders},
                modifier = Modifier.clickable(onClick = {if (count>1) {onCountChange(count-1)} else{}})
            )

            Box(modifier = Modifier.width(1.dp).height(16.dp).background(InputStr))

            Icon(
                painter = painterResource(R.drawable.icon_plus),
                contentDescription = null,
                tint = Placeholders,
                modifier = Modifier.clickable(onClick = {onCountChange(count + 1)})
            )
        }
    }


}

@Preview
@Composable
fun PrewiewCounter(){
    counter(1,{})

}
