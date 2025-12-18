package com.example.uikit.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Black
import com.example.uikit.UI.Placeholders
import com.example.uikit.UI.Typography
import com.example.uikit.buttons.smallButton
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import kotlin.collections.get

@Composable
fun projectCard(TextTitle: String, date: String, onClick: () ->Unit){
    val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.US)

    val CurrentDate =CurrentDateTime()

    Box() {
        backgroundCards()

        Column(
            modifier = Modifier.height(138.dp).padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Text(TextTitle, style = Typography().Headline_Medium, color = Black)

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {

                val arrayDate = parsingByTime(date)

                var TextData = "${CurrentDate[2].toString()}.${CurrentDate[1].toString()}.${CurrentDate[0].toString()}"

                if((CurrentDate[0]==arrayDate[0]) and (CurrentDate[1]==arrayDate[1])
                    and (CurrentDate[2]==arrayDate[2]) and (CurrentDate[3]==arrayDate[3])){
                    TextData = "Недавний"
                }
                else if ((CurrentDate[0]==arrayDate[0]) and (CurrentDate[1]==arrayDate[1])
                    and (CurrentDate[2]==arrayDate[2])){
                    TextData = "Сегодня"
                }
                else if ((CurrentDate[0]==arrayDate[0]) and (CurrentDate[1]==arrayDate[1]))
                    TextData = "Прошло ${CurrentDate[2]-arrayDate[2]} дня"

                Text(
                    "$TextData", modifier = Modifier.padding(bottom = 4.dp),
                    style = Typography().Caption_Semibold, color = Placeholders
                )

                smallButton(true, "Открыть", onClick)

            }


        }
    }
}

fun parsingByTime(BuyTime: String): Array<Int>{
    val dateString = BuyTime

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS'Z'")
    val dateTime = LocalDateTime.parse(dateString, formatter)

    val ArrayData: Array<Int> = arrayOf(
        dateTime.year,
        dateTime.monthValue,
        dateTime.dayOfMonth,
        dateTime.hour,
        dateTime.minute,
        dateTime.second
    )

    return ArrayData
}

fun CurrentDateTime(): Array<Int>{
    val currentDateTime = LocalDateTime.now()
    val ArrayData: Array<Int> = arrayOf(
        currentDateTime.year,
        currentDateTime.monthValue,
        currentDateTime.dayOfMonth,
        currentDateTime.hour,
        currentDateTime.minute,
        currentDateTime.second
    )
    return ArrayData
}


@Preview
@Composable
fun PreviewProject(){
    projectCard("Мой первый проект", "2",{})
}


