package com.cesarwillymc.technicaltestwordbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.cesarwillymc.technicaltestwordbox.ui.theme.GreenCrossTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreenCrossTheme {

            }
        }
    }
}
