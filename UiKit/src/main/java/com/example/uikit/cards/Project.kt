package com.example.uikit.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Black
import com.example.uikit.UI.Placeholders
import com.example.uikit.UI.Typography
import com.example.uikit.buttons.smallButton
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun projectCard(title: String, date: String, onClick: () -> Unit) {
    val formattedDate = formatProjectDate(date)

    backgroundCards {
        Column(Modifier.height(138.dp).padding(16.dp), Arrangement.SpaceBetween) {
            Text(title, style = Typography().Headline_Medium, color = Black)

            Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween, Alignment.Bottom) {
                Text(
                    formattedDate,
                    modifier = Modifier.padding(bottom = 4.dp),
                    style = Typography().Caption_Semibold,
                    color = Placeholders
                )
                smallButton(true, "Открыть", onClick)
            }
        }
    }
}

private fun formatProjectDate(dateString: String): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS'Z'")
    val date = LocalDateTime.parse(dateString, formatter)
    val now = LocalDateTime.now()

    return when {
        date.year == now.year && date.monthValue == now.monthValue &&
                date.dayOfMonth == now.dayOfMonth && date.hour == now.hour -> "Недавний"
        date.year == now.year && date.monthValue == now.monthValue &&
                date.dayOfMonth == now.dayOfMonth -> "Сегодня"
        date.year == now.year && date.monthValue == now.monthValue ->
            "Прошло ${now.dayOfMonth - date.dayOfMonth} дня"
        else -> "${date.dayOfMonth}.${date.monthValue}.${date.year}"
    }
}


@Preview
@Composable
fun PreviewProject(){
    projectCard("Мой первый проект", "2024-12-01",{})
}