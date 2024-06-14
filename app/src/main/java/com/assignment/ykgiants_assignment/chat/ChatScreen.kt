package com.assignment.ykgiants_assignment.chat

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import com.assignment.ykgiants_assignment.component.textfield.ChatTextField
import com.assignment.ykgiants_assignment.component.topbar.ChatTopBar
import com.assignment.ykgiants_assignment.model.Message
import com.assignment.ykgiants_assignment.chat.viewModel.ChatViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ChatScreen(
    modifier: Modifier = Modifier,
    chatViewModel: ChatViewModel = viewModel(),
) {
    var messages by remember { mutableStateOf(listOf<Message>()) }
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(Unit) {
        chatViewModel.firstMessage { newMessages ->
            messages = messages + newMessages
        }
        chatViewModel.startReceivingMessages { newMessage ->
            messages = messages + newMessage
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .clickable {
                keyboardController?.hide()
            }
            .imePadding(),
    ) {
        ChatTopBar()

        MessageScreen(
            messages = messages,
            modifier = modifier
                .weight(1f)
        )


        ChatTextField(
            placeholder = "메시지를 입력하세요",
            onButtonClick = { text ->
                chatViewModel.addMessage(messages, text) { newMessages ->
                    messages = newMessages
                }
            },
            modifier = modifier
                .fillMaxWidth()
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun ChatScreenPreview() {
    ChatScreen()
}