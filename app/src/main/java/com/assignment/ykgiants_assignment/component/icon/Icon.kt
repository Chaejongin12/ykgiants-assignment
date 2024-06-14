package com.assignment.ykgiants_assignment.component.icon

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.assignment.ykgiants_assignment.R

@Composable
fun BackButtonIcon() {
    Image(
        painter = painterResource(id = R.drawable.ic_back_button),
        contentDescription = "Back Button"
    )
}

@Composable
fun MenuButtonIcon() {
    Image(
        painter = painterResource(id = R.drawable.ic_menu_button),
        contentDescription = "Menu Button"
    )
}