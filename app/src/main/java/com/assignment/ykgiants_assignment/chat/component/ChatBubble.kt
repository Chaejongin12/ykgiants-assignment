package com.assignment.ykgiants_assignment.chat.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.assignment.ykgiants_assignment.chat.util.toKoreanFormat
import com.assignment.ykgiants_assignment.model.Message
import java.time.LocalTime


@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun ChatBubble(
    message: Message,
    modifier: Modifier = Modifier,
) {
    var currentTime by remember { mutableStateOf(LocalTime.now().toKoreanFormat()) }
    val backgroundColor = if (message.isSentByMe) Color.Cyan else Color.LightGray
    val horizontalArrangement = if (message.isSentByMe) Arrangement.End else Arrangement.Start

    LaunchedEffect(Unit) {
        currentTime = LocalTime.now().toKoreanFormat()
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = horizontalArrangement
    ) {
        Column(
            horizontalAlignment = if (message.isSentByMe) Alignment.End else Alignment.Start,
            modifier = modifier.widthIn(max = (LocalConfiguration.current.screenWidthDp.dp / 2))

        ) {
            Box(
                modifier = modifier
                    .background(color = backgroundColor, shape = RoundedCornerShape(10.dp))
                    .padding(8.dp)
            ) {
                Text(
                    text = message.text,
                    color = Color.Black,
                    fontSize = 16.sp,
                    modifier = modifier.wrapContentWidth()
                )
            }

            Text(
                text = currentTime,
                color = Color.Black,
                fontSize = 12.sp,
                modifier = modifier.align(if (message.isSentByMe) Alignment.Start else Alignment.End)
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
internal fun ChatBubblePreview() {
    Column(
        modifier = Modifier.background(Color.White)
    ) {
        ChatBubble(
            message = Message("안녕하세요? 저는 채종인입니다.", isSentByMe = true)
        )

        ChatBubble(
            message = Message("네 반갑습니다. 저는 유쾌한 거인입니다.", isSentByMe = false)
        )
    }
}