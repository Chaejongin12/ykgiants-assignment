package com.assignment.ykgiants_assignment

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.core.view.WindowCompat
import com.assignment.ykgiants_assignment.chat.ChatScreen
import com.assignment.ykgiants_assignment.ui.theme.YkgiantsassignmentTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        enableEdgeToEdge()
        setContent {
            YkgiantsassignmentTheme {
                ChatScreen()
            }
        }
    }
}