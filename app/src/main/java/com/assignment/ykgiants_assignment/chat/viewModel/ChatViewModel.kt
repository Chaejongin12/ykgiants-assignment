package com.assignment.ykgiants_assignment.chat.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.ykgiants_assignment.model.Message
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Random


class ChatViewModel : ViewModel() {
    private val randomMessages = listOf(
        "안녕! 나 유쾌한 거인이야",
        "뭐하고 지냈어?",
        "뭐해?",
        "그거 멋진데??",
        "진짜?",
        "알겠어",
        "나쁘지 않네~",
        "만나서 반가워"
    )

    internal fun firstMessage(onMessageReceived: (Message) -> Unit) = viewModelScope.launch {
        val random = Random()
        for(i in 0..4) {
            val randomMessage = randomMessages[random.nextInt(randomMessages.size)]
            onMessageReceived(Message(randomMessage, random.nextBoolean()))
        }
    }

    internal fun addMessage(
        messages: List<Message>,
        text: String,
        onMessagesUpdated: (List<Message>) -> Unit,
    ) = viewModelScope.launch {
        val newMessages = messages + Message(text = text, isSentByMe = true)
        onMessagesUpdated(newMessages)
    }


    internal fun startReceivingMessages(onMessageReceived: (Message) -> Unit) =
        viewModelScope.launch {
            val random = Random()
            while (true) {
                delay(5000)
                val randomMessage = randomMessages[random.nextInt(randomMessages.size)]
                onMessageReceived(Message(randomMessage, false))
            }
        }
}