package com.example.uikit.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Placeholders
import com.example.uikit.UI.Typography

data class TabItem(
    val iconId: Int,
    val title: String
)

@Composable
fun TabBar(
    selectedTab: String,
    onTabSelected: (String) -> Unit,
    tabs: List<TabItem> = defaultTabs()
) {
    Box(Modifier.fillMaxWidth().height(88.dp)) {
        Row(Modifier.fillMaxWidth().padding(horizontal = 7.dp, vertical = 8.dp),
            Arrangement.SpaceBetween) {
            tabs.forEach { tab ->
                TabItemView(tab, selectedTab == tab.title) { onTabSelected(tab.title) }
            }
        }
    }
}

@Composable
private fun TabItemView(tab: TabItem, isSelected: Boolean, onClick: () -> Unit) {
    Column(
        Modifier.size(76.dp, 49.dp).clickable{onClick()},
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(painterResource(tab.iconId), null, Modifier.size(32.dp),
            tint = if (isSelected) Accent else Placeholders)
        Text(tab.title, style = Typography().Caption2_Regular,
            color = if (isSelected) Accent else Placeholders)
    }
}

private fun defaultTabs() = listOf(
    TabItem(R.drawable.home, "Главная"),
    TabItem(R.drawable.catalog, "Каталог"),
    TabItem(R.drawable.project, "Проекты"),
    TabItem(R.drawable.profile, "Профиль")
)

@Preview
@Composable
fun TabBarPreviewInteractive() {
    var selectedTab by remember { mutableStateOf("Главная") }


    Column(Modifier.fillMaxSize()) {
            Spacer(Modifier.weight(1f))
        TabBar(
            selectedTab = selectedTab,
            onTabSelected = { tab -> selectedTab = tab }
        )
        }
}