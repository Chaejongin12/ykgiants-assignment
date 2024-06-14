package com.assignment.ykgiants_assignment.component.button

import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.assignment.ykgiants_assignment.component.icon.SendButtonIcon

@Composable
fun SendButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        SendButtonIcon()
    }
}

@Preview
@Composable
fun ButtonPreview() {
    SendButton(onClick = {})
}