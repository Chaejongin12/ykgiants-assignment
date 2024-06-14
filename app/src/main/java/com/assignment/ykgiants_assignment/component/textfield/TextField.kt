package com.assignment.ykgiants_assignment.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.assignment.ykgiants_assignment.component.button.SendButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatTextField(
    modifier: Modifier = Modifier,
    placeholder: String,
    onButtonClick: (String) -> Unit,
) {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { inputString ->
            text = inputString
        },
        placeholder = {
            Text(
                text = placeholder,
                color = Color.Gray
            )
        },
        maxLines = 4,
        trailingIcon = {
            if (text.isNotEmpty()) {
                SendButton(
                    onClick = {
                        onButtonClick(text)
                        text = ""
                    }
                )
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 2.dp,
                color = Color.Cyan,
            )
            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = Color.Cyan,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            focusedPlaceholderColor = Color.Cyan,
            unfocusedPlaceholderColor = Color.Cyan,
        ),
    )
}

@Preview
@Composable
fun TextFieldPreview() {
    ChatTextField(
        onButtonClick = {},
        placeholder = "메시지를 입력하세요"
    )
}