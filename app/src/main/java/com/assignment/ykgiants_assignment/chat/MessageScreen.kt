package com.assignment.ykgiants_assignment.chat

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import com.assignment.ykgiants_assignment.chat.component.ChatBubble
import com.assignment.ykgiants_assignment.model.Message

@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun MessageScreen(
    messages: List<Message>,
    modifier: Modifier = Modifier,
) {
    val listState = rememberLazyListState()

    LazyColumn(
        modifier = modifier
            .systemBarsPadding()
            .background(color = Color.White),
        state = listState
    ) {
        items(messages) { message ->
            ChatBubble(message = message, modifier = Modifier.zIndex(-1f))
        }
    }

    LaunchedEffect(messages.size) {
        listState.scrollToItem(messages.size)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
internal fun MessageScreenPreview() {
    MessageScreen(
        messages = listOf(
            Message("Hello", isSentByMe = true),
            Message("Hi", isSentByMe = false),
            Message("How are you?", isSentByMe = true),
            Message("I'm fine", isSentByMe = false),
        )
    )
}