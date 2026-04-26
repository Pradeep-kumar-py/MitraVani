package com.example.mitravani

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.mitravani.navigation.AppNavigator
import com.example.mitravani.ui.theme.MitraVaniTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MitraVaniTheme {
                AppNavigator()
            }
        }
    }
}
