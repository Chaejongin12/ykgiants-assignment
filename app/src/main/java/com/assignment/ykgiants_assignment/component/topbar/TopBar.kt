package com.assignment.ykgiants_assignment.component.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.assignment.ykgiants_assignment.component.icon.BackButtonIcon
import com.assignment.ykgiants_assignment.component.icon.MenuButtonIcon

@Composable
fun ChatTopBar(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .background(color = Color.Cyan)
            .padding(vertical = 12.dp, horizontal = 8.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.SpaceBetween
    ) {
        BackButtonIcon()

        Text(
            text = "유쾌한 거인",
            color = Color.Black,
            modifier = Modifier.padding(start = 12.dp)
        )

        MenuButtonIcon()
    }
}

@Preview
@Composable
fun TopBarPreview() {
    ChatTopBar()
}