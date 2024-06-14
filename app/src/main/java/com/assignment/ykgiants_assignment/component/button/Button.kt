package com.assignment.ykgiants_assignment.component.button

import androidx.compose.foundation.background
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SendButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier
            .background(color = Color.Cyan),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Cyan,
            contentColor = Color.White
        ),
    ) {
        Text(text = "전송", color = Color.Black)
    }
}

@Preview
@Composable
fun ButtonPreview() {
    SendButton(onClick = {})
}