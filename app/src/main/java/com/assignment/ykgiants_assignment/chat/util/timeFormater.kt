package com.assignment.ykgiants_assignment.chat.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
fun LocalTime.toKoreanFormat(): String {
    val hour = this.hour
    val minute = this.minute
    val amPm = if (hour < 12) "오전" else "오후"
    val formattedHour = if (hour % 12 == 0) 12 else hour % 12 // 12시간 형식으로 변경

    return "$amPm $formattedHour:$minute"
}
